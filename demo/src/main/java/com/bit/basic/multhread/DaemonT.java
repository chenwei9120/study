package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DaemonT.java
 * @Description TODO
 * @createTime 2019年11月08日 23:07:00
 */
public class DaemonT {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            while (true) {
                try {
                    while(true) {
                        Thread.sleep(100);
                        System.out.println("deamon print");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("sub thread will exit");
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(500);
        System.out.println("main thread will exit.");
        System.exit(0);
    }

}