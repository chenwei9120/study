package com.bit.conditon;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName A.java
 * @Description TODO
 * @createTime 2020年04月12日 00:26:00
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class A {
    public A()  {
        System.out.println("A()");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getToken() {
        return "token";
    }
}