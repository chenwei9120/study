package com.example.aop_demo.aspectj.dao;

import org.springframework.stereotype.Component;

@Component
public class OrderDao implements IDao {

    public void save() {
        System.out.println("OrderDao::dao");
    }
}
