package com.example.beanfactorypostprocessor_test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HelloDao.java
 * @Description TODO
 * @createTime 2020年05月07日 16:31:00
 */
//@Component
public class HelloDao {

    public HelloDao() {
        System.out.println("HelloDao()");
    }
}