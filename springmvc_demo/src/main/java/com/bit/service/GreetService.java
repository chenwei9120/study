package com.bit.service;

import com.bit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName GreetService.java
 * @Description TODO
 * @createTime 2020年05月15日 02:10:00
 */
@Service
public class GreetService {


    @Autowired
    private  User user1;

    public String sayHello(String name) {
        return "Hello " + name + "---user=" + user1;
    }
}