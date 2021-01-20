package com.bit.sync;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TestSyncAndModify.java
 * @Description TODO
 * @createTime 2020年05月19日 01:55:00
 */
public class TestSyncAndModify implements Runnable {

    private A syncA;

    @Override
    public void run() {
        synchronized (syncA) {
            System.out.println(Thread.currentThread().getName() + "_begin");
            syncA = new A();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "_end");
        }
    }

    static class A {
    }

    public static void main(String[] args) {
        TestSyncAndModify sync = new TestSyncAndModify();
        A testA = new A();
        sync.syncA = testA;
        Thread one = new Thread(sync);
        Thread two = new Thread(sync);
        one.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        two.start();
    }
}