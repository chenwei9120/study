package com.bit.basic.generic;

public class Food implements IFood {
    @Override
    public Food createIntance() {
        return new Food();
    }
}
