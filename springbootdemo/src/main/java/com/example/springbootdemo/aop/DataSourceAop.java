package com.example.springbootdemo.aop;

import com.example.springbootdemo.datasource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DataSourceAop.java
 * @Description TODO
 * @createTime 2019年11月06日 14:39:00
 */

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.example.springbootdemo.annotation.Master) " +
            "&& (execution(* com.example.springbootdemo.service..*.select*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.springbootdemo.annotation.Master) " +
            "|| execution(* com.example.springbootdemo.service..*.insert*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.add*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.update*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.edit*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.delete*(..)) " +
            "|| execution(* com.example.springbootdemo.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}