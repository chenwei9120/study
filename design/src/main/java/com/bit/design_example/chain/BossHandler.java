package com.bit.design_example.chain;


public class BossHandler extends ZhaoPingHandler {

    public BossHandler(int score, String name) {
        super(score, name, "boss");
    }

    public void notice(boolean isAgree) {
        System.out.println(" Interviewer发送消息通知");
    }
}
