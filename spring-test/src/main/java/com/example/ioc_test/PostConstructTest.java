package com.example.ioc_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PostConstructTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        context.start();
        PostConstructTest a = (PostConstructTest)context.getBean("postConstructTest");
        PostConstructTest b = (PostConstructTest)context.getBean("postConstructTest");
        if(a.equals(b)) {
            System.out.println("default scope is singonton");
        } else {
            System.out.println("default scope is prototype");
        }
    }

    @Autowired
    private BBB b;

    public PostConstructTest() {
        System.out.println("此时b还未被注入: b = " + b);
    }

    public void init(){
        System.out.println("init(): b = " + b);
    }

    @PostConstruct
    private void post() {
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("@PreDestroy: b = " + b);
    }

    private void destroy() {
        System.out.println("destroy(): b = " + b);
    }

    public static class BBB {
        public BBB() {
            System.out.println("BBB");
        }
    }
}
