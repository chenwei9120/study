package com.bit.aware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年04月12日 17:57:00
 */
@Configuration
@ComponentScan({"com.bit.aware"})
public class MainClass {

    @Autowired(required = false)
    private AwareService service;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
        System.out.println(context.getBean(AwareService.class));

    }
}