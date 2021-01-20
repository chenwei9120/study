package com.example.proxy;

import com.example.aop_demo.aspectj.dao.IDao;
import com.example.aop_demo.aspectj.dao.OrderDao;

public class JdkProxy {
    public static void main(String[] args) {
        // 目标对象
        IDao target = new OrderDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IDao proxy = (IDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}
