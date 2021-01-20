package com.example.depends_on_test;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName B.java
 * @Description TODO
 * @createTime 2019年12月25日 15:52:00
 */

public class B {

    // //同样可以注入,并且不要set方法
    @Autowired
    private A a;

    //配置文件中如果开启default-autowire="byType，可以自动将A的对象装配进来。但是default-autowire需要set方法才能注入
    public void setA(A a) {
        System.out.println("setA function");
        this.a = a;
    }

    public B() {
        System.out.println("B's contruction.");
    }

    public void printA() {
        System.out.println(a);
    }
}