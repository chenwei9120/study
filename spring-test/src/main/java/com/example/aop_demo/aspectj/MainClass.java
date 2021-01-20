package com.example.aop_demo.aspectj;

import com.example.aop_demo.aspectj.config.AppConfig;
import com.example.aop_demo.aspectj.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //没有接口实现，使用cglib代理
        IndexDao dao = (IndexDao)context.getBean("indexDao");
        System.out.println(dao.getClass().getName());
        dao.query();

        //实现接口的，默认使用jdk.由于有@EnableAspectJAutoProxy(proxyTargetClass = true)，强制使用了cglib代理
//        IDao dao = (IDao)context.getBean("orderDao");
//        System.out.println(dao.getClass().getName());
//        dao.save();

        //Unsafe.getUnsafe().monitorEnter();
    }
}
