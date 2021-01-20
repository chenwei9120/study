package com.bit.annotation.hello;

import java.lang.reflect.Method;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HelloTest.java
 * @Description TODO
 * @createTime 2020年03月03日 11:46:00
 */

public class HelloTest {

    @Hello("Hello, World.")
    public void HelloMethod(){
        System.out.println("Hello Method.");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        HelloTest helloTest = new HelloTest();
        helloTest.HelloMethod();
        Class cls = helloTest.getClass();
        Method method = cls.getMethod("HelloMethod");
        Hello hello = method.getAnnotation(Hello.class);
        System.out.println(hello.value());
    }
}