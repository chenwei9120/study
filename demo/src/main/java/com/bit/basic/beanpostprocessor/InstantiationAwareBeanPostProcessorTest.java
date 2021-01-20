package com.bit.basic.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName InstantiationAwareBeanPostProcessorTest.java
 * @Description TODO
 * @createTime 2020年04月23日 16:54:00
 */
@Component
public class InstantiationAwareBeanPostProcessorTest implements InstantiationAwareBeanPostProcessor {//

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("bottle")) {
            System.out.println("postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("bottle")) {
            System.out.println("postProcessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equals("bottle")) {
            System.out.println("postProcessProperties");
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("bottle")) {
            System.out.println("postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("bottle")) {
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }


}