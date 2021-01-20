package com.bit.dao;

import org.springframework.stereotype.Component;

@Component
public class OrderDao implements IDao {

    @Override
    public void save() {
        System.out.println("dao------save");
    }
}
