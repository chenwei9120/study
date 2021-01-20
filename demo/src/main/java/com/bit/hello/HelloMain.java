package com.bit.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HelloMain.java
 * @Description TODO
 * @createTime 2020年04月29日 15:05:00
 */


public class HelloMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HelloBean helloBean = context.getBean("helloBean", HelloBean.class);
        System.out.println(helloBean.toString());
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            context.close();
        }));
    }
}