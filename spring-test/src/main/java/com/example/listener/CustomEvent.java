package com.example.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomEvent.java
 * @Description TODO
 * @createTime 2020年02月21日 14:16:00
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
}