package com.bit.lock;

public class DeadLock {
    /**
     * 使用jstack 排查死锁
     *
     * @author dufyun
     */

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTest(true));//建立一个线程
        Thread t2 = new Thread(new DeadLockTest(false));//建立另一个线程
        t1.setName("thread-dufy-1");
        t2.setName("thread-dufy-2");
        t1.start();//启动一个线程
        t2.start();//启动另一个线程
    }
}
