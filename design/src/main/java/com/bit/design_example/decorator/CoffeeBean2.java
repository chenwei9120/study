package com.bit.design_example.decorator;

public class CoffeeBean2  implements IBeverage{
    private String description = "第二种咖啡豆！";

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return 100;
    }
}
