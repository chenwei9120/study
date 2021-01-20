package com.bit.design_example.adpter;

import java.text.SimpleDateFormat;

public class Adapter implements IAdapter {

    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public String targetMethod() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(adaptee.getDate());
    }
}
