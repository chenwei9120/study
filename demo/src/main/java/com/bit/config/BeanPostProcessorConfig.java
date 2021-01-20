package com.bit.config;

import com.bit.basic.beanpostprocessor.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {

    @Bean
    public BeanPostProcessor beanHandler() {
        return new BeanPostProcessor();
    }
}
