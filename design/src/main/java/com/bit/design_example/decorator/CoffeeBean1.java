package com.bit.design_example.decorator;

public class CoffeeBean1  implements IBeverage {

    private String description = "选了第一种咖啡豆";

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return 50;
    }
}
