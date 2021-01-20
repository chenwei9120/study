package com.example.config;

import com.example.model.Car;
import com.example.model.Address;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2019年11月11日 16:41:00
 */

public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Car car = (Car)context.getBean("car");
        System.out.println(car);
//        System.out.println(context.getBean("schoolFactory"));
//        System.out.println(context.getBean(SchoolFactory.class));
//        System.out.println(context.getBean("&schoolFactory"));
        System.out.println(context.getBean(Address.class));
        context.close();
    }
}