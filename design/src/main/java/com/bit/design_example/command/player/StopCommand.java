package com.bit.design_example.command.player;

public class StopCommand implements Command {
    private Player player = null;

    public StopCommand(Player player) {
        this.player = player;
    }

    public void action(Object... args) {
        try {
            player.action("stop", args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
