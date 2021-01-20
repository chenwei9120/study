package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ThreadWait.java
 * @Description TODO
 * @createTime 2020年03月09日 17:12:00
 */
public class ThreadWait {

    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t1 will start and will wait");
                System.out.println(System.currentTimeMillis());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(System.currentTimeMillis());
                    System.out.println("t1 will exit");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait(100);
                    System.out.println("t2 will start and wait");
                    System.out.println(System.currentTimeMillis());
                    object.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(System.currentTimeMillis());
                    System.out.println("t2 will exit");
                }
            }
        });
        t2.start();
    }
}