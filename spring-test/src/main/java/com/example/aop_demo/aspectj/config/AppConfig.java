package com.example.aop_demo.aspectj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.aop_demo")
//@EnableAspectJAutoProxy  默认就是开启的
//xml配置 <aop:aspectj-autoproxy proxy-target-class="true"/>
@EnableAspectJAutoProxy(proxyTargetClass = true)//aop强制使用cglib，即使是接口实现
public class AppConfig {
}
