package com.bit.listener;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName PlayerListener.java
 * @Description TODO
 * @createTime 2020年03月14日 22:50:00
 */
public class PlayerListener implements IPlayListener {
    @Override
    public void onEvent(PlayEvent event) {
        System.out.println("palyer is playing " + event.getFileName());
    }
}