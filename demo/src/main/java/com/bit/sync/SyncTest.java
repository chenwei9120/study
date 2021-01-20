package com.bit.sync;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SyncTest.java
 * @Description TODO
 * @createTime 2020年05月19日 02:09:00
 */
public class SyncTest {
    public SyncTest syncVar;

    public static SyncTest syncStaticVar;

    public static synchronized void testStaticSync() {}

    public synchronized void testNonStaticSync() {}

    public void testSyncThis() {
        synchronized (this) {
            try {
                System.out.println("test sync this start");
                Thread.sleep(5000);
                System.out.println("test sync this end");
            } catch (InterruptedException e) {
            }
        }
    }
    public void testSyncVar() {
        synchronized (syncVar) {
            try {
                System.out.println("test sync var start");
                Thread.sleep(3000);
                System.out.println("test sync var end");
            } catch (InterruptedException e) {
            }
        }
    }
    public void testStaticSyncVar() {
        synchronized (syncStaticVar) { }
    }

    public static void main(String[] args) {
        final SyncTest testSync = new SyncTest();
        testSync.syncVar = new SyncTest();
        testSync.syncVar = testSync;
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.testSyncThis();
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.testSyncVar();
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}