package com.bit.design_example.buider;

public class Client {

    public static void main(String[] args) {
        Builder builder = new BMWBuilder();
        Director director = new Director(builder);
        Car car = director.construct();
        System.out.println(car);
    }

}
