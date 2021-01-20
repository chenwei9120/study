package com.example.aop_demo.autoproxycreator;

import org.springframework.stereotype.Component;

@Component
public class Human implements Sleepable {
    @Override
    public void sleep() {
        System.out.println("睡觉中");
    }
}
