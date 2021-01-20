package com.bit.design_example.command.player;

import java.lang.reflect.InvocationTargetException;

public class Player {

    public void action(String actionName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Player.class.getDeclaredMethod(actionName, getArgsType(args)).invoke(this, args);
    }

    private Class<?>[] getArgsType(Object... args) {
        if(args == null || args.length == 0) {
            return null;
        }
        Class<?>[] classes = new Class[args.length];
        for(int i = 0; i <args.length; ++i) {
            classes[i] = args[i].getClass();
        }
        return classes;
    }

    private void play(String resource) {
        System.out.println("play " + resource);
    }

    private void stop() {
        System.out.println("stop ");
    }

    private void pause() {
        System.out.println("pause ");
    }
}
