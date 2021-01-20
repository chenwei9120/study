package com.bit.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建一个Semaphore 有5条许可
        final Semaphore semaphore = new Semaphore(5);
        Table talbe = new Table();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //申请一个许可  许可池-1   若许可池为0则申请许可失败，阻塞线程
                        semaphore.acquire();
                        System.out.println(finalI
                        );
                        //模仿耗时操作
                        Thread.sleep(1000);
                        //释放一个许可  许可池+1
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static class Table  {
        Table() {
            System.out.println("create table object");
        }
    }
}
