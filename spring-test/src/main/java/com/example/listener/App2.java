package com.example.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName App.java
 * @Description TODO
 * @createTime 2020年02月21日 14:24:00
 */
public class App2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config-listen2.xml");
        context.publishEvent(new ApplicationEvent("我是中国人") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
    }
}