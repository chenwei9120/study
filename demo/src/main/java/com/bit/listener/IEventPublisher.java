package com.bit.listener;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName IEventPublisher.java
 * @Description TODO
 * @createTime 2020年03月14日 22:44:00
 */
public interface IEventPublisher {
    void register(IPlayListener listener);

    void publish(PlayEvent event);
}