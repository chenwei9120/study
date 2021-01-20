package com.bit.design_example.buider;

public class AudiBuilder implements Builder {

    private Car car = new AudiA6();

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
