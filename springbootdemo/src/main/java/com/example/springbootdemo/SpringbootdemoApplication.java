package com.example.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
        if (context.containsBean("commodity")) {
            System.out.println("可以扫描到当前包上层的bean");
        } else {
            System.out.println("只扫描当前包和子包的bean");
        }

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动结束");
    }
}
