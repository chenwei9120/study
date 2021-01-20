package com.example.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName App.java
 * @Description TODO
 * @createTime 2020年02月21日 14:24:00
 */
@Component
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.publishEvent();
    }

    public void publishEvent() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-config-listen.xml");
        CustomEvent event = ctx.getBean(CustomEvent.class);
        ctx.publishEvent(event);
    }
}