package com.example.model;

import java.io.Serializable;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年05月15日 02:16:00
 */
public class User implements Serializable {
    private Integer id;
    private String name;

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