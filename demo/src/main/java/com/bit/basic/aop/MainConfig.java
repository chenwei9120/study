package com.bit.basic.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by way on 2019/6/10.
 */
@Configuration
//proxyTargetClass = true，不管有没有接口都使用cglib生成代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAspectJAutoProxy(exposeProxy = true)
public class MainConfig {

    @Bean
    public Calculate calculate() {
        return new AOPCalculate();
    }

    @Bean
    public AOPLogAspect tulingLogAspect() {
        return new AOPLogAspect();
    }
}
