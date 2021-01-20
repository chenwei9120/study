package com.bit.basic.inherit.animal;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Bird.java
 * @Description TODO
 * @createTime 2020年04月02日 14:44:00
 */
public class Bird extends Animal {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    //是否是益鸟
    protected boolean isUseful;

    public Bird() {
        System.out.println("Bird()");
    }

    @Override
    public void eat() {

    }

    public Bird(boolean isUseful, String name) {
        //this();
        this.name = name;
        this.isUseful = isUseful;
        System.out.println("Bird(boolean isUseful, String name)");
    }

    public void fly() {
        System.out.println("bird can fly.");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}