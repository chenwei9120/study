package com.example.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomBeanPostProcessor.java
 * @Description TODO
 * @createTime 2020年03月31日 00:40:00
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println(beanName + " BeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println(beanName + " AfterInitialization");
        if (bean instanceof People) {
            System.out.println(beanName + "--postProcessAfterInitialization");
        }
//
//        if (bean instanceof Contact) {
//            System.out.println(beanName);
//        }
        return bean;
    }
}