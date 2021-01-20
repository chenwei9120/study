package com.example.depends_on_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName App.java
 * @Description TODO
 * @createTime 2019年12月25日 15:59:00
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config-dependon.xml");
        //((ClassPathXmlApplicationContext) context).start();
        B b = (B) context.getBean("b");
        b.printA();
    }
}