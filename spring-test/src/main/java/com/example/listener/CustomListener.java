package com.example.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomListener.java
 * @Description TODO
 * @createTime 2020年02月21日 14:17:00
 */
public class CustomListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof CustomEvent) {
            System.out.println("接收到自定义事件");
            //ApplicationContext context = ((ContextRefreshedEvent) event).getApplicationContext();
            System.out.println(event.getSource());
        }
    }
}