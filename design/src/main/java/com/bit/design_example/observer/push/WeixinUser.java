package com.bit.design_example.observer.push;

//WeixinUser
public class WeixinUser implements Observer {
    // 微信用户名
    private String name;
    
    public WeixinUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
