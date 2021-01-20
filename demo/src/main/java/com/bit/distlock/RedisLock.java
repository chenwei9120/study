package com.bit.distlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.unit.DataUnit;

import java.util.concurrent.TimeUnit;

public class RedisLock {
    //持有锁超时时间
    static final long HOLD_MSECS = 3000;
    //锁等待超时时间
    static final long TIMEOUT_MSECS = 3000;
    //重试获取时间
    static final long RETRY_INTERVAL = 100;

    long timeoutMsecs = TIMEOUT_MSECS;

    long holdMsecs = HOLD_MSECS;

    private String lockKey;

    private volatile boolean locked = false;

    @Autowired
    private static StringRedisTemplate redisTemplate;

    public RedisLock(String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey + "_lock";
    }

    public RedisLock(String lockKey, int timeoutMsecs) {
        this(lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    public RedisLock(String lockKey, int timeoutMsecs, int holdMsecs) {
        this(lockKey, timeoutMsecs);
        this.holdMsecs = holdMsecs;
    }

    public String getLockKey() {
        return this.lockKey;
    }

    public boolean acquire() {
        byte[] lock = lockKey.getBytes();
        StringRedisSerializer serializer = new StringRedisSerializer();
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {
            Long newExpireTime = System.currentTimeMillis() + this.holdMsecs;
            long timeout = this.timeoutMsecs;
            byte[] newExpireTimeBytes = newExpireTime.toString().getBytes();
            while (!redisTemplate.<String>opsForValue().setIfAbsent(lockKey, newExpireTime.toString(),30, TimeUnit.SECONDS)) {
                if (timeout < 0) {
                    return false;
                }
                String expireTime = serializer.deserialize(connection.get(lock));
                if (expireTime != null && Long.parseLong(expireTime) < System.currentTimeMillis()) {
                    connection.watch(lock);
                    connection.multi();
                    byte[] oldValue = connection.getSet(lock, newExpireTimeBytes);
                    if (connection.exec() != null) {
                        if (oldValue == null) {
                            locked = true;
                        } else {
                            String oldExpire = serializer.deserialize(oldValue);
                            if (oldExpire != null && Long.parseLong(oldExpire) < System.currentTimeMillis()) {
                                locked = true;
                            }
                        }
                        connection.close();
                        return locked;
                    }
                } else {
                    connection.unwatch();
                }
                timeout = timeout - RETRY_INTERVAL;
                try {
                    Thread.sleep(RETRY_INTERVAL);
                } catch (InterruptedException e) {
                    return false;
                }
            }
            locked = true;
            return locked;
        });
    }

    public synchronized void unlock() {
        if (locked) {
            redisTemplate.execute((RedisCallback) connection -> {
                StringRedisSerializer serializer = new StringRedisSerializer();
                byte[] lock = lockKey.getBytes();
                String expireTime = serializer.deserialize(connection.get(lock));
                if (expireTime != null && Long.parseLong(expireTime) > System.currentTimeMillis()) {
                    connection.del(lockKey.getBytes());
                    connection.close();
                    locked = false;
                }
                return locked;
            });
        }
    }

    //系统启动时初始化使用
    public synchronized void clear() {
        redisTemplate.execute((RedisCallback) connection -> {
            StringRedisSerializer serializer = new StringRedisSerializer();
            byte[] lock = lockKey.getBytes();
            String expireTime = serializer.deserialize(connection.get(lock));
            if (expireTime != null && Long.parseLong(expireTime) > System.currentTimeMillis()) {
                connection.del(lockKey.getBytes());
                locked = false;
            }
            return locked;
        });
    }

    public boolean isLocked() {
        return locked;
    }
}
