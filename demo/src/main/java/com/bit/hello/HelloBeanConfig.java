package com.bit.hello;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HelloBeanConfig.java
 * @Description TODO
 * @createTime 2020年05月18日 20:36:00
 */
@Configuration
public class HelloBeanConfig {

    @Bean(initMethod = "init", destroyMethod = "dispose")
    @ConfigurationProperties(prefix = "hello")
    public HelloBean helloBean() {
        return new HelloBean();
    }
}