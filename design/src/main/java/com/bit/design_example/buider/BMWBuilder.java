package com.bit.design_example.buider;

public class BMWBuilder implements Builder {

    private Car car = new BMWX7();

    public void buildEngine() {
        car.buildEngine();
    }

    public void buildTyre() {
        car.buildTyre();
    }

    public void buildWindow() {
        car.buildWindow();
    }

    public Car getCar() {
        buildEngine();
        buildTyre();
        buildWindow();
        return car;
    }
}
