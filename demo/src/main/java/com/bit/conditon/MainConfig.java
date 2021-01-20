package com.bit.conditon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.bit.conditon")
public class MainConfig {

    @Autowired
    private A a;

    @Bean
    public A a(){
        return new A();
    }

    @Bean
    @ConditionalOnClass(A.class)
    public B b() {
        System.out.println(a.getToken());
        return new B();
    }
}
