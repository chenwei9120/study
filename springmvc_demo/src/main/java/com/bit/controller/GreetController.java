package com.bit.controller;


import com.bit.model.User;
import com.bit.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

    @Autowired
    private GreetService greetService;

    @RequestMapping("/greet")
    public String sayHello(String name) {
//        if(1==1) {
//            throw new RuntimeException("自定义异常处理");
//        }
        return greetService.sayHello(name);
    }

    @PostMapping(value = "/user/create")
    @ResponseBody
    public String createGreet(@RequestBody(required=true) User user) {
        return user.getId() + user.getName();
    }

    @PostMapping("/test")
    @ResponseBody
    public String create(@RequestParam("str") String str, @RequestParam("str2") String str2) {//
        return str + str2;
    }
}
