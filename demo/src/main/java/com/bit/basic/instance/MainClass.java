package com.bit.basic.instance;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年04月30日 09:28:00
 */
public class MainClass {
    public static void main(String[] args) {
        IConnect connectObject = new IConnect() {
            @Override
            public void connect() {
                System.out.println("connect function");
            }
        };
        connectObject.connect();
    }
}