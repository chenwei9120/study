package com.bit.design_example.chain;

public abstract class ZhaoPingHandler {

    public ZhaoPingHandler(int score, String name, String role) {
        this.score = score;
        this.name = name;
        this.role = role;
    }

    protected int score;

    protected String name;

    protected String role;

    private ZhaoPingHandler next;

    public ZhaoPingHandler getNext() {
        return next;
    }

    public void setNext(ZhaoPingHandler next) {
        this.next = next;
    }

    protected boolean agree() {
        if (score < 60) {
            return false;
        }
        return true;
    }

    public abstract void notice(boolean isAgree);

    //这里结合使用了模板方法模式
    public void interview() {
        boolean isAgree = false;
        if (!agree()) {
            System.out.println(this.role + this.name + "觉得这个人不行。");
        } else {
            System.out.println(this.role + this.name + "觉得这个人可以。");
            isAgree = true;
        }
        notice(isAgree);
        if (getNext() != null && isAgree) {
            getNext().interview();
        }
    }
}
