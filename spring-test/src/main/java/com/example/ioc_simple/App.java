package com.example.ioc_simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ComponentScan("com.example.ioc_simple")
public class App {

    @Autowired
    private SimpleBean simpleBean;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        //System.out.println(context.getBean(SimpleBean.class));
        App app = context.getBean(App.class);
        app.print();
    }

    public void print() {
        System.out.println(simpleBean);
    }
}
