package com.example.aop_demo.autoproxycreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SleepConfig.class);
        Sleepable sleepable = (Sleepable)context.getBean("human");
        sleepable.sleep();
    }
}
