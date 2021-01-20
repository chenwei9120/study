package com.example.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年03月04日 00:10:00
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(ctx.getBean("person"));
    }
}