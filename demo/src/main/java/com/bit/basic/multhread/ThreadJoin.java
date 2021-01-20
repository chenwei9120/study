package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ThreadJoin.java
 * @Description TODO
 * @createTime 2019年11月08日 22:39:00
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i < 100000000) {
                ++i;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
        });
        t1.start();
        t1.join();
        System.out.println("finished.");

    }
}