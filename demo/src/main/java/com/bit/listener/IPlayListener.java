package com.bit.listener;

import java.util.EventListener;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IPlayListener.java
 * @Description TODO
 * @createTime 2020年03月14日 18:59:00
 */
public interface IPlayListener extends EventListener {

    void onEvent(PlayEvent event);
}