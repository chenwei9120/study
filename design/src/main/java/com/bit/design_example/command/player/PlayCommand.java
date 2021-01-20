package com.bit.design_example.command.player;


public class PlayCommand implements Command {

    private Player player = null;

    public PlayCommand(Player player) {
        this.player = player;
    }

    public void action(Object... args) {
        try {
            //相关操作
            player.action("play", args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
