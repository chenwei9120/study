package com.bit.design_example.command.player;

public class PlayerTest {

    public static void main(String[] args) {
        Player player = new Player();
        Command playCommand = new PlayCommand(player);
        Command pauseCommand = new PauseCommand(player);
        Command stopCommand = new StopCommand(player);
        playCommand.action("c:\\东风破.mp3");
        pauseCommand.action();
        stopCommand.action();
    }
}
