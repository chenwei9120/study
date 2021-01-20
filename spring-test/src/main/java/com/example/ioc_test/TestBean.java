package com.example.ioc_test;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TestBean.java
 * @Description TODO
 * @createTime 2020年02月23日 17:19:00
 */
public class TestBean implements ApplicationListener<ContextStartedEvent> {
    static ClassPathXmlApplicationContext context = null;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        context.start();
        EventTest eventTest = (EventTest) context.getBean("eventTest");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(eventTest);
    }

    public void onApplicationEvent(ContextStartedEvent contextRefreshEvent) {
        System.out.println("Event:-----------------" + contextRefreshEvent.toString());
    }

}