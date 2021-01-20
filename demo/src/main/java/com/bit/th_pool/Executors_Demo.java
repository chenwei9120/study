package com.bit.th_pool;

import java.util.concurrent.*;

public class Executors_Demo {

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService service = Executors.newCachedThreadPool();

        ExecutorService service = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for(int i = 0;i < 100; ++i) {
            service.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        if(service.isTerminated()) {
            System.out.println("isTerminated");
            service.shutdown();
        }
        service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("主线程结束");

    }
}
