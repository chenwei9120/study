package com.bit.basic.inherit.animal;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Magpie.java
 * @Description TODO
 * @createTime 2020年04月02日 14:46:00
 */
public class Magpie extends Bird {
    public Magpie() {
        System.out.println("Mappie()");
    }

    public Magpie(boolean isUseful, String name) {
        this();
        System.out.println("Magpie(boolean isUseful, String name)");
    }

    public static void main(String[] args) {
        Magpie magpie = new Magpie(true, "magpie");
    }
}