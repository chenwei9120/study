package com.example.ioc_simple;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    public SimpleBean() {
        System.out.println("---------------------------------");
    }
}
