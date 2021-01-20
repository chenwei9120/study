package com.bit.th_pool.queue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MovieTiket.java
 * @Description TODO
 * @createTime 2020年03月05日 22:16:00
 */
public class MovieTiket implements Delayed {
    //延迟时间
    private final long delay;

    public long getDelay() {
        return delay;
    }

    public long getExpire() {
        return expire;
    }

    public String getMsg() {
        return msg;
    }

    public long getNow() {
        return now;
    }

    //到期时间
    private final long expire;
    //数据
    private final String msg;
    //创建时间
    private final long now;

    /**
     * @param msg 消息
     * @param delay 延期时间
     */
    public MovieTiket(String msg , long delay) {
        this.delay = delay;
        this.msg = msg;
        expire = System.currentTimeMillis() + delay;    //到期时间 = 当前时间+延迟时间
        now = System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire
                - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS)
                - delayed.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "MovieTiket{" +
                "delay=" + delay +
                ", expire=" + expire +
                ", msg='" + msg + '\'' +
                ", now=" + now +
                '}';
    }
}