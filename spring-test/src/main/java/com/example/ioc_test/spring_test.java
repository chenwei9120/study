package com.example.ioc_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class spring_test {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");

        ((ClassPathXmlApplicationContext) context).start();
        HelloBean helloBean1 = context.getBean("helloBean", HelloBean.class);
        HelloBean helloBean2 = context.getBean("helloBean", HelloBean.class);
//        HelloBean helloBean2 = context.getBean("helloBean", HelloBean.class);
//        if(helloBean1.equals(helloBean2)) {
//            System.out.println("helloBean1 equals helloBean2");
//        } else {
//            System.out.println("helloBean1 not equals helloBean2");
//        }
        helloBean1.preDestroy();
        helloBean1.destroy();
        context.close();
        if(System.in.read() >0) {

        }
        context.stop();
    }
}
