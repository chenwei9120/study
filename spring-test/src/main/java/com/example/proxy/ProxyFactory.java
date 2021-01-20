package com.example.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象，生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("开启事务");
//                        // 执行目标对象方法
//                        Object returnValue = method.invoke(target, args);
//                        System.out.println("提交事务");
//                        return returnValue;
//                    }
//                });
    }
}
