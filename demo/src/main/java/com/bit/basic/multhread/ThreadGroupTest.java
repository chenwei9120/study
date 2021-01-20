package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ThreadGroupTest.java
 * @Description TODO
 * @createTime 2020年01月11日 16:37:00
 */
public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup threadGroup = new ThreadGroup("group1");
        //threadGroup.setDaemon(true);//与threadGroup.interrupt不同，此处设置deamon对线程不起作用
        Thread thread1 = new Thread(threadGroup, new ThreadTest(), "thread1");
        //thread1.setDaemon(true);
        System.out.println(thread1.isDaemon());
        thread1.start();
        Thread thread2 = new Thread(threadGroup, new ThreadTest(), "thread2");
        //thread2.setDaemon(true);
        thread2.start();
        Thread.sleep(1000);
        System.out.println(threadGroup.activeCount());

        Thread.sleep(1000);
        thread1.interrupt();
        System.out.println(threadGroup.activeCount());
        //threadGroup.interrupt();//可以向group中所有的线程发送中断异常
        Thread.sleep(1000);
        thread2.interrupt();
        System.out.println(threadGroup.activeCount());
    }

    static class ThreadTest implements Runnable {

        @Override
        public void run() {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted");
                    break;
                }
                else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(Thread.currentThread().getName() + " print ");
                }
            }
        }
    }
}