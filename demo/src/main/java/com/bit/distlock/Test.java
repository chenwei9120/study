package com.bit.distlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {

    @Autowired
    private RedisTemplate redisTemplate;

    public void basicTest() {
        redisTemplate.opsForValue().set("newKey0824", "2019-8-24");
        String value = (String) redisTemplate.opsForValue().get("newKey0824");
        System.out.println(value);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.basicTest();;
    }
}
