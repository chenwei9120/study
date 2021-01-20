package com.bit.design_example.chain;

public class HRHandler extends ZhaoPingHandler {

    public HRHandler(int score, String name) {
        super(score, name, "hr");
    }

    public void notice(boolean isAgree) {
        System.out.println("hr:" + this.name + "发送消息通知");
    }
}
