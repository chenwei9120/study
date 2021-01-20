package com.example.test;

import com.example.model.Address;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Import(Car.class)
public class TestApplication {

    public TestApplication() {
        System.out.println("TestApplication init.");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-config.xml");
        context.start();
        People people = (People) context.getBean("people");
        System.out.println(people);

        people = (People) context.getBean("people");
        System.out.println(people);

        Address address = people.getAddress();
        if (address != null) {
            System.out.println(address.getProvince() + "--" + address.getCity() + "--" + address.getDistrict());
        }

        School school = (School) context.getBean("schoolFactory");
        System.out.println(school);
    }
}
