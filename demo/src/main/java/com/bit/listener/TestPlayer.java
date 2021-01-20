package com.bit.listener;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TestPlayer.java
 * @Description TODO
 * @createTime 2020年03月14日 19:04:00
 */
public class TestPlayer{

    public static void main(String[] args) {
        PlayerListener listenerObject = new PlayerListener();
        Player player = new Player();
        player.register(listenerObject);
        player.play("说好不哭");
    }
}