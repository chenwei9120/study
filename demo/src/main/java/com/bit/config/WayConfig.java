package com.bit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WayConfig {

    public void init() {
        System.out.println("init function.");
    }

    @Bean(initMethod = "init",name = "conifgName")
    public WayConfig initTest(){
        System.out.println("initTest function");
        return new WayConfig();
    }
}
