package com.bit.basic.inherit;

public class Son extends Parent {
    public Son(String name) {
        super(name);//构造需要显示调用
        System.out.println("Son " + name);
    }

    static {//类构造器不需要显示调用父类的类构造器(clinit)，由虚拟机保证在执行子类的clinit方法前，父类的clinit已经执行完毕。
        System.out.println("Son clinit");
    }

    public static void main(String[] args) {
        new Son("Way");
    }
}
