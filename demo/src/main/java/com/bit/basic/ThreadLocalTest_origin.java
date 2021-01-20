package com.bit.basic;

public class ThreadLocalTest_origin {

    static ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            counter.set(10);
            count("thread1");
        }).start();
        counter.set(100);
        count("thread main");
    }

    static void count(String threadName){
        System.out.println(String.format("id=%d;name=%s;hashcode=%s",
                counter.get(), threadName, counter.toString()));
    }
}
