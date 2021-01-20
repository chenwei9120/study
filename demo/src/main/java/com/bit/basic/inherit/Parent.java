package com.bit.basic.inherit;

public class Parent {
    public Parent(String name) {
        System.out.println("Parent " + name);
    }

    static {
        System.out.println("Parent clinit");
    }
}
