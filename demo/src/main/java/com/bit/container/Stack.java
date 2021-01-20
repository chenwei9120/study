package com.bit.container;

import java.util.LinkedList;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Stack.java
 * @Description TODO
 * @createTime 2020年05月20日 23:17:00
 */
public class Stack {
    LinkedList list = new LinkedList();

    public synchronized void push(Object x) {
        synchronized (list) {
            list.addLast(x);
            notify();
        }
    }

    public synchronized Object pop() throws Exception {
        synchronized (list) {
            if (list.size() <= 0) {
                wait();
            }
            return list.removeLast();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        new Thread(() -> {
            while (true) {
                stack.push(new String("new one item."));
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Object object = stack.pop();
                    System.out.println(object.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
    }
}