package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target = null;
    public MyInvocationHandler(Object targetObject) {
        target = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务");
        return returnValue;
    }
}
