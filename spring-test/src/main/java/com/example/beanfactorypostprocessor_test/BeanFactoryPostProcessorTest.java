package com.example.beanfactorypostprocessor_test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName BeanFactoryPostProcessorTest.java
 * @Description TODO
 * @createTime 2020年05月07日 17:30:00
 */
//@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Iterator it = beanFactory.getBeanNamesIterator();
        String[] names = beanFactory.getBeanDefinitionNames();
        GenericBeanDefinition beanDefinition = null;
        //获取了所有的bean名称列表
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            beanFactory.getBeanDefinition(name);
            if (name.equals("helloService")) {
                beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition(name);
                //beanDefinition.setBeanClass(IndexDao.class);
                System.out.println(beanDefinition.getAutowireMode());
                beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_NO);
            }

            if (name.equals("person")) {
                beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition(name);
                ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
                constructorArgumentValues.addIndexedArgumentValue(0,12345);
                beanDefinition.setConstructorArgumentValues(constructorArgumentValues);
            }
        }
    }
}