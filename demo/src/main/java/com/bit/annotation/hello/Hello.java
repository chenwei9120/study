package com.bit.annotation.hello;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Hello.java
 * @Description TODO
 * @createTime 2020年03月03日 11:44:00
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Hello {
    String value();
}