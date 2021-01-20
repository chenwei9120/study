package com.bit.conditon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName B.java
 * @Description TODO
 * @createTime 2020年04月12日 00:26:00
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class B {

    public B() {
        System.out.println("B()");
    }
}