package com.bit.th_pool.queue.delay;

import java.util.concurrent.DelayQueue;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DelayedQueueTest.java
 * @Description TODO
 * @createTime 2020年03月05日 22:00:00
 */
public class DelayedQueueTest {
    public static void main(String[] args) {
        DelayQueue<MovieTiket> delayQueue = new DelayQueue<>();
        MovieTiket tiket = new MovieTiket("电影票0", 10000);
        delayQueue.put(tiket);
        MovieTiket tiket1 = new MovieTiket("电影票1", 5000);
        delayQueue.put(tiket1);
        MovieTiket tiket2 = new MovieTiket("电影票2", 8000);
        delayQueue.put(tiket2);
        System.out.println("message:--->入队完毕");

        while (delayQueue.size() > 0) {
            try {
                tiket = delayQueue.take();
                System.out.println("电影票出队:" + tiket.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}