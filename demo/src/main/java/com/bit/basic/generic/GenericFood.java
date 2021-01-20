package com.bit.basic.generic;

public class GenericFood<T extends IFood> {
    public static void main(String[] args) {
        IFood food = new Food();
        System.out.println(food);
        Food food1 = food.createIntance();
        System.out.println(food1);
    }


}
