package com.example.beanfactorypostprocessor_test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年05月07日 16:29:00
 */
public class MainClass {

    public static void main(String[] args) {
        new MainClass();
    }


    public MainClass() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config-factotrypostprocessor.xml");
        //HelloService helloService = applicationContext.getBean(HelloService.class);
        HelloService helloService = applicationContext.getBean(HelloService.class);
        System.out.println(helloService);
        System.out.println(helloService.getHelloDao());
    }
}