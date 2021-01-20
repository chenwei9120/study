package com.example.beanfactorypostprocessor_test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IndexDao.java
 * @Description TODO
 * @createTime 2020年05月07日 16:33:00
 */
//@Repository
public class IndexDao {

    public IndexDao() {
        System.out.println("IndexDao()");
    }
}