package com.bit.conditon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年04月12日 00:15:00
 */

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        configApplicationContext.getBean(B.class);
    }
}