package com.example.ioc_test;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EventTest implements ApplicationListener<ContextStartedEvent> {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        context.start();
        //EventTest eventTest = context.getBean("eventTest", EventTest.class);
    }

    public void onApplicationEvent(ContextStartedEvent contextRefreshEvent) {
        System.out.println("Event:-----------------" + contextRefreshEvent.toString());
    }
}
