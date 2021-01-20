package com.bit.basic.beanpostprocessor;

import com.bit.hello.HelloBean;
import org.springframework.beans.BeansException;

public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("helloBean")) {
            HelloBean helloBean = (HelloBean) bean;
            System.out.println(helloBean.getName() + "---------" + helloBean.getAge());
        }
        return bean;
    }
}
