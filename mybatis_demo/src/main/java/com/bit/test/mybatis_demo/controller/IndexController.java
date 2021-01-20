package com.bit.test.mybatis_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2019年12月07日 00:43:00
 */
@RestController
public class IndexController {

    @GetMapping
    public String index() {
        return "msg:Index from server.";
    }
}