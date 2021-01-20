package com.example.aop_demo.config;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config-aop.xml");
        Sleepable sleepable = (Sleepable)context.getBean("human");
        sleepable.sleep();
    }
}
