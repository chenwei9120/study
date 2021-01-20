package com.example.aop_demo.aspectj.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//动态织入
//切面类
//生成代理对象
//目标对象为com.example.aop_demo.dao下面的所有类
@Aspect
@Component
public class TlAspect {

    @Pointcut("execution(* com.example.aop_demo.aspectj.dao.*.*(..))")//定义切入点
    public void pointCut() {
    }

    @After("com.example.aop_demo.aspectj.config.TlAspect.pointCut()")//通知(advice增强器)
    public void after() {//关注点，和业务相关的非业务代码
        System.out.println("after");
    }

    @Before("com.example.aop_demo.aspectj.config.TlAspect.pointCut()")
    public void before() {
        System.out.println("before");
    }
}
