package com.example.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

@Repository
public class Contact {

    public Contact() {
        System.out.println("Contact create.");
    }

    private String name;

    private String cell;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
}
