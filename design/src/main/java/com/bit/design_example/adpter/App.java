package com.bit.design_example.adpter;

public class App {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        IAdapter adapter = new Adapter(adaptee);
        System.out.println(adapter.targetMethod());
    }
}
