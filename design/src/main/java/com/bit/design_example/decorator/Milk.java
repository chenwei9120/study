package com.bit.design_example.decorator;

//public class Milk extends Decorator {
public class Milk implements IBeverage {
    private String description = "加了牛奶！";
    private IBeverage beverage = null;

    public Milk(IBeverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    public double getPrice() {
        return beverage.getPrice() + 20;    //20表示牛奶的价格
    }
}
