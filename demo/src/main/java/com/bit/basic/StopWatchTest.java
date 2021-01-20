package com.bit.basic;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName StopWatchTest.java
 * @Description TODO
 * @createTime 2020年03月31日 22:33:00
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch("11");
        watch.start("watch elapse time");
        long l = System.currentTimeMillis();
        System.out.println(l);
        Thread.sleep(1000);
        long k = System.currentTimeMillis();
        System.out.println(k);
        System.out.println(k - l);
        System.out.println(watch.currentTaskName());
        watch.stop();

        watch.start("watch elapse time2");
        System.out.println(watch.currentTaskName());
        watch.stop();
        System.out.println(watch.getTotalTimeSeconds());
    }
}