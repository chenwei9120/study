package com.bit.distlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisTest {

    public static void main(String[] args) throws InterruptedException {
        Long dateStart = System.currentTimeMillis();
        Thread.sleep(1000);
        Long dateEnd = System.currentTimeMillis();
        System.out.println(dateEnd - dateStart);

    }
}
