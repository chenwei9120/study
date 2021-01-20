package com.example.aop_demo.proxyfactorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SleepConfig.class);
        Sleepable sleepable = (Sleepable)context.getBean("humanProxy");
        sleepable.sleep();
    }
}
