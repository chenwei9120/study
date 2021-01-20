package com.bit.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2019年11月21日 21:09:00
 */
@Data
public class User implements Serializable {

    public User() {

    }
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;

    private String name;
}