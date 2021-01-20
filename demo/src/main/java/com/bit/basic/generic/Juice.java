package com.bit.basic.generic;

public class Juice <T extends Fruit> {

    public void writeInfo(T t) {
        System.out.print(String.format("产地：%s, 名称：%s", t.getAddress(), t.getName()));
    }

    public static void main(String[] args) {
        Juice<Fruit> juice = new Juice<>();
        Peach peach = new Peach();
        peach.setName("毛桃");
        peach.setAddress("黄山");
        juice.writeInfo(peach);
    }
}
