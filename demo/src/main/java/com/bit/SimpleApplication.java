package com.bit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SimpleApplication.java
 * @Description TODO
 * @createTime 2020年04月01日 00:36:00
 */
@SpringBootApplication
@RestController
public class SimpleApplication {



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/helloworld")
    public String hello() {

        return "Hello World!";
    }
}