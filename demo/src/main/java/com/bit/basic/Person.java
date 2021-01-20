package com.bit.basic;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2019年12月11日 02:49:00
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

//@Lazy
@Component//如果是启动类，可以不加该注解
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//singleton
@ComponentScan({"com.bit.basic"})
@RestController
public class Person {

    final static Logger logger = LoggerFactory.getLogger(Person.class);

    public Person() {
        System.out.println("Person");
    }

    @GetMapping("/")
    public String HelloPerson() {
        return "Hello Person!";
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Person.class);
        ((AnnotationConfigApplicationContext) context).start();
        System.out.println(context.getBean("person"));
        logger.info("spring debug");
        context.publishEvent(new ApplicationEvent("我是中国人") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}