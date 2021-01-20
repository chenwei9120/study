package com.bit.th_pool.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SimpleBlockingQueue.java
 * @Description TODO
 * @createTime 2020年03月05日 16:34:00
 */
public class SimpleBlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.offer("Hello.");
        blockingQueue.offer("World.");
        String s = blockingQueue.poll();
        System.out.println(s);
    }

}