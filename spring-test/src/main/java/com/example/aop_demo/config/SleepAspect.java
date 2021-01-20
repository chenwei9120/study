package com.example.aop_demo.config;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class SleepAspect {

    public void afterSleep() throws Throwable {
        System.out.println("起床刷牙...");
    }

    public void beforeSleep() throws Throwable {
        System.out.println("睡前刷牙...");
    }
}
