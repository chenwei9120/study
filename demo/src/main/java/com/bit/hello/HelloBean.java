package com.bit.hello;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class HelloBean implements InitializingBean, DisposableBean {

    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloBean() {
        System.out.println("*****************************************************");
        System.out.println("HelloBean::construct");
    }


    public void init() {
        System.out.println("HelloBean::init");
    }

    public void dispose() {
        System.out.println("HelloBean::destroy");
    }

    @PostConstruct
    public void load() {
        System.out.println("HelloBean::@PostConstructTest");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("HelloBean::InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("HelloBean::DisposableBean.destroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("HelloBean::DisposableBean.predestroy");
    }


}
