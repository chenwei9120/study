package com.example.aop_demo.aspectj.dao;

import org.springframework.stereotype.Component;

@Component
public class IndexDao {
    public void query(){
        System.out.println("dao------query");
    }
}
