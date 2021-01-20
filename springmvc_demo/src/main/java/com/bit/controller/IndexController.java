package com.bit.controller;

import com.bit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2020年01月27日 10:07:00
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@RequestBody User user, HttpServletRequest request) {
        request.getSession().setAttribute("name", user.getName());
        System.out.println(user.getName());
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public void write(String word, HttpServletRequest request) {
        request.getSession().setAttribute("word", word);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(HttpServletRequest request) {
         return String.valueOf(request.getSession().getAttribute("word"));
    }
}