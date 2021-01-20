package com.bit.design_example.command.player;

public class PauseCommand implements Command {

    private Player player = null;

    public PauseCommand(Player player) {
        this.player = player;
    }

    public void action(Object... args) {
        try {
            player.action("pause", args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
