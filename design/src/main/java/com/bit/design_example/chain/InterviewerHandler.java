package com.bit.design_example.chain;

public class InterviewerHandler extends ZhaoPingHandler {

    public InterviewerHandler(int score, String name) {
        super(score, name, "interviewer");
    }

    public void notice(boolean isAgree) {
        System.out.println("Interviewer" + this.name + "发送消息通知");
    }
}
