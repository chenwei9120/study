package com.example.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Car.java
 * @Description TODO
 * @createTime 2019年11月11日 16:37:00
 */


public class Car implements InitializingBean, DisposableBean {
    //@PostConstruct
    public void init() {
        System.out.println("Car::init");
    }

    //@PreDestroy
    public void destroy() {
        System.out.println("Car::destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Car::afterPropertiesSet");
    }
}