package com.bit.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TableTest.java
 * @Description TODO
 * @createTime 2020年02月04日 12:05:00
 */
public class TableTest {

    private Node tail = new Node();

    private long tailOffset;


    //使用方法
    private Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

    private Unsafe unsafe = null;

    public TableTest() throws NoSuchFieldException, IllegalAccessException {
        unsafe = getUnsafeInstance();
        tailOffset = unsafe.objectFieldOffset
                (TableTest.class.getDeclaredField("tail"));
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //SemaphoreDemo.Table table = new SemaphoreDemo.Table();
        TableTest test = new TableTest();
        System.out.println(test.compareAndSetTail());
    }

    public boolean compareAndSetTail() {
        long oldTailOffset = tailOffset;
        Node expect = tail;
        Node update = new Node();
        //unsafe.compareAndSwapObject执行完后，tail的指向已经变了
        boolean b = unsafe.compareAndSwapObject(this, tailOffset, expect, update);
        return expect.equals(tail);
    }

    static class Node {

    }
}