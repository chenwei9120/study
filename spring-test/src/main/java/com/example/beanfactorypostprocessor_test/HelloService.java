package com.example.beanfactorypostprocessor_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HelloService.java
 * @Description TODO
 * @createTime 2020年05月07日 16:30:00
 */
//@Component
public class HelloService {
    //@Autowired
    private HelloDao helloDao;

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }
}