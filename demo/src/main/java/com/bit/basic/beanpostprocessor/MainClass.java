package com.bit.basic.beanpostprocessor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年04月23日 16:58:00
 */
@Configuration
@ComponentScan("com.bit.basic.beanpostprocessor")
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainClass.class);
        Bottle bottle = ctx.getBean("bottle",Bottle.class);
        System.out.println(bottle.getName());

    }
}