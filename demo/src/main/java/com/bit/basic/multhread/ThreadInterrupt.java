package com.bit.basic.multhread;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ThreadInterrupt.java
 * @Description TODO
 * @createTime 2019年11月08日 16:00:00
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
       Thread t1 = new Thread(()->{
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("will break.");
                    break;
                }
                System.out.println("in sub thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
       t1.start();

        try {
            Thread.sleep(2000);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}