package com.bit.design_example.chain;

public class Client {
    public static void main(String[] args) {
        ZhaoPingHandler hr = new HRHandler(70, "张三" );
        ZhaoPingHandler interviewer = new InterviewerHandler(50,"李四");
        //0 表示没有面
        ZhaoPingHandler boss = new InterviewerHandler(0,"王五");
        hr.setNext(interviewer);
        interviewer.setNext(boss);
        hr.interview();
    }
}
