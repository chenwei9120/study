package com.example.controller;

import com.example.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2020年01月27日 10:07:00
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        System.out.println(user.getName());
    }
}