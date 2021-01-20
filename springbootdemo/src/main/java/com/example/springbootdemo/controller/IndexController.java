package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2020年01月04日 18:46:00
 */
@RestController
public class IndexController {

    @Value("${server.port}")
    private String port ;

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        //return "forward:index.html";
        InetAddress ia = InetAddress.getLocalHost();
        return ia.getHostAddress() + ":" + port;
    }

    @RequestMapping("/get/{id}")
    public String getObjectById(@PathVariable("id") String id, @RequestParam("name") String name) {
        return Long.valueOf(id) + name;
    }
}