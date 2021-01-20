package com.bit.basic.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomListener.java
 * @Description TODO
 * @createTime 2020年04月02日 18:14:00
 */
@Component
public class CustomListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //if(event instanceof CustomEvent) {
        System.out.println("接收到自定义事件");
        //ApplicationContext context = ((ContextRefreshedEvent) event).getApplicationContext();
        System.out.println(event.getSource());
        //}
    }
}