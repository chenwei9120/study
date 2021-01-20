package com.bit.basic.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public <T extends Fruit> void func(List<T> list) {
        list.stream().forEach(f -> System.out.println(f.getName()));
    }

    public <S> void func2(List<S> list) {
        //list.stream().forEach(f -> System.out.println(f));
        System.out.println(list.getClass());
    }

    public static void main(String[] args) {

        GenericTest fruitGenericTest = new GenericTest();
        Peach peach = new Peach();
        peach.setName("黄桃");
        peach.setAddress("黄山");
        List<Peach> list = new ArrayList<>();
        list.add(peach);
        fruitGenericTest.func(list);
        fruitGenericTest.func2(list);

        //上界
        System.out.println("---------------上界------------------------------");
        List<? extends Fruit> listFruit = new ArrayList<Peach>(list);
        //listFruit.add(null);
        //add Fruit对象会报错
        //listFruit.add((Fruit) peach);
        Fruit fruit1 = listFruit.get(0);

        Apple apple = new Apple();
        apple.setName("国光");
        apple.setAddress("山东");

        //下界
        System.out.println("---------------下界------------------------------");
        List<? super Fruit> listFruitBottom = new ArrayList<Fruit>();
        listFruitBottom.add(peach);
        listFruitBottom.add(apple);
        listFruitBottom.stream().forEach(f -> System.out.println(((Fruit)f).getName()));
        Fruit fruit = (Fruit) listFruitBottom.get(0);
       // fruit.setName("水蜜桃"); 测试是否可以对属性赋值
        System.out.println("---------------------------------------------------");
        System.out.println(fruit.getName());
        //可以赋值，却无法取值
        //Fruit fruit = flistBottem.get(0);
    }
}
