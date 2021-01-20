package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SingleInstanceTest.java
 * @Description TODO
 * @createTime 2020年03月31日 20:49:00
 */
public class SingleInstanceTest {

    private static SingleInstanceTest singleObject = null;

    //private final static SingleInstanceTest singleObject = new SingleInstanceTest();
    private SingleInstanceTest() {
        System.out.println("create SingleObject with hashcode=" + Integer.valueOf(this.hashCode()));
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            SingleInstanceTest.get();
        });
        Thread thread2 = new Thread(() -> {
            SingleInstanceTest.get();
        });
        thread1.start();
        thread2.start();
    }

    static {
        if (singleObject == null) {
            singleObject = new SingleInstanceTest();
        }
    }

    public static SingleInstanceTest get() {
        return singleObject;
    }
}