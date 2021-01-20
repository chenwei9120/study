package com.bit.design_example.buider;

//真正的建造者。construct()实现了整体构建的算法。
public class Director {
    Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car construct(){
        this.builder.buildEngine();
        this.builder.buildTyre();
        this.builder.buildEngine();
        return this.builder.getCar();
    }
}
