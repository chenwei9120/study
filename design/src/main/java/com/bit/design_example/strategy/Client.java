package com.bit.design_example.strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyB();
        Context context = new Context(strategy);
        context.contextInterface();
    }
}
