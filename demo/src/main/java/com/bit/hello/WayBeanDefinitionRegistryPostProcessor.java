package com.bit.hello;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class WayBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //AnnotationConfigUtils.registerAnnotationConfigProcessors在最初硬编码，注册了8个bean
        System.out.println("加载bean定义前bean的数量" + registry.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("加载bean定义后bean的数量" + beanFactory.getBeanDefinitionCount());
    }
}
