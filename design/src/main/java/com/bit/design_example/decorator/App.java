package com.bit.design_example.decorator;

public class App {
    public static void main(String[] args) {
        IBeverage beverage = new CoffeeBean1();
        beverage = new Milk(beverage);
        beverage = new Sugar(beverage);
        System.out.println(beverage.getDescription() + "\n加了糖和牛奶的咖啡价格：" + beverage.getPrice());
    }
}
