package com.example.test;

import com.example.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class People  {

    public People() {
        System.out.println("People create.");
    }

    private Address address;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("People init.");
    }

    public void destroy() {
        System.out.println("TestApplication.destroy");
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }
}
