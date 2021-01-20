package com.example.beanfactorypostprocessor_test;

import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2020年05月08日 16:29:00
 */

public class Person {
    private Integer id;

    private String name;

    public Person(){
        System.out.println("Person()");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Person(String name)");
    }

    public Person(Integer id) {
        this.id = id;
        System.out.println("Person(Integer id)");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}