package com.bit.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomBeanNameAware.java
 * @Description TODO
 * @createTime 2020年04月12日 17:55:00
 */
@Component
public class CustomBeanNameAware implements BeanNameAware, BeanFactoryAware {

    private BeanFactory factory = null;

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }
}