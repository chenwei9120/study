package com.bit.th_pool;

import java.util.concurrent.*;

public class first {
    public static void main(String[] args) {
        //ExecutorService service = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor executor =  new ThreadPoolExecutorEx(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
         for(int i =0; i < 20; ++i) {
             executor.submit(() -> {
//                 try {
                     System.out.println(Thread.currentThread().getName());
                     //Thread.currentThread().sleep(1000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
             });
         }
         while (true) {
             if(executor.isTerminated()) {
                 break;
             }
             try {
                 executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
                 System.out.println(executor.getActiveCount());
                 executor.shutdown();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
