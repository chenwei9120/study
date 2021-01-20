package com.bit.th_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ExecutorTest.java
 * @Description TODO
 * @createTime 2020年03月17日 18:02:00
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService sevice = Executors.newCachedThreadPool();
        sevice.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Print in work thread.");
            }
        });
        System.out.println("Print in main thread.");
    }
}