package com.example.alias_est;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年04月11日 22:20:00
 */
public class MainClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring-config-alias.xml");
        BasicDataSource source =  applicationContext.getBean("datac",BasicDataSource.class);
        System.out.println(source.getUsername());
    }
}