package com.example;

import com.example.springbootdemo.model.Commodity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TestBean.java
 * @Description TODO
 * @createTime 2020年03月03日 20:45:00
 */
@Configuration
public class TestBean {
    @Bean
    public Commodity commodity() {
        return new Commodity();
    }
}