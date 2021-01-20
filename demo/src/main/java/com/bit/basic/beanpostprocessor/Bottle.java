package com.bit.basic.beanpostprocessor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Bottle.java
 * @Description TODO
 * @createTime 2020年04月23日 17:14:00
 */
@Component
public class Bottle implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----afterPropertiesSet");
    }

    public String getName() {
        return "dddddd";
    }

    public Bottle() {
        System.out.println("###############Bottle()###############");
    }
}