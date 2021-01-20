package com.bit.future_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ThreadPoolExecutorTest.java
 * @Description TODO
 * @createTime 2020年03月10日 07:21:00
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        IntStream.range(0,5).forEach((i)->{
            service.submit(new Task(i));
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(((ThreadPoolExecutor) service).getPoolSize());
    }

    private static class Task implements Runnable {
        private int index;
        public Task(int i) {
            index = i;
        }
        @Override
        public void run() {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getId());
        }
    }
}