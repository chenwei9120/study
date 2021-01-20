package com.example.ioc_test;

import com.example.test.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName PeopleTest.java
 * @Description TODO
 * @createTime 2020年03月31日 23:41:00
 */
public class PeopleTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        People people =  (People) context.getBean("people");
        System.out.println(people.getName());
        System.out.println(people.getAddress());
    }
}