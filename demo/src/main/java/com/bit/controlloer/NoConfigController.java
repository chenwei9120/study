package com.bit.controlloer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName NoConfigController.java
 * @Description 这个类是测试过滤器的用法。不会被容器加载
 * @createTime 2019年12月12日 13:40:00
 */
@RestController
public class NoConfigController {

    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public String test() {
        return "NoConfigController::test";
    }
}