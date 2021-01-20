package com.bit.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //4条线程
        int threadCount = 4;
        //创建一个拥有5个计数器的countDownLatch
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //使计数器-1
                    countDownLatch.countDown();
                    System.out.println("计数器还剩" + countDownLatch.getCount());
                }
            }).start();
        }
        try {
            //在这里阻塞  只有计数器为0的时候这行代码才会释放
                countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成啦！");
    }
}
