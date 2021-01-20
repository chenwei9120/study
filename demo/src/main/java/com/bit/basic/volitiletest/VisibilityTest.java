package com.bit.basic.volitiletest;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName VisibilityTest.java
 * @Description TODO
 * @createTime 2020年01月09日 11:03:00
 */
public class VisibilityTest extends Thread {
    private volatile boolean stop;

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
//            String s = "12345";
//            s.split("");
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws Exception {
        VisibilityTest v = new VisibilityTest();
        v.start();
        Thread.sleep(1000);//此处注释掉就不会
        v.stopIt();
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}