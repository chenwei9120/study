package com.example.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Bus.java
 * @Description TODO
 * @createTime 2019年12月11日 02:13:00
 */
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Bus {
    public Bus() {
        System.out.println("Bus::Bus");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Bus.class);
        context.start();
        System.out.println(context.getBean("bus"));
        System.out.println(context.getBean("bus").getClass());
//        new PrototypeTest().createBus();
//        new PrototypeTest().createBus();
    }
}