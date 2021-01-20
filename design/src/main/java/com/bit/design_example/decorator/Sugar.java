package com.bit.design_example.decorator;

public class Sugar implements IBeverage {

    private String description = "加了糖！";
    private IBeverage beverage = null;

    public Sugar(IBeverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    public double getPrice() {
        return beverage.getPrice() + 25;    //25 表示加糖的价格
    }
}
