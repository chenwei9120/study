package com.bit.basic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ScheduledExecutorServiceTest.java
 * @Description TODO
 * @createTime 2019年11月05日 15:54:00
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run "+ System.currentTimeMillis());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
}