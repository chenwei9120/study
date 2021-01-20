package com.bit.design_example.template;

public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public final void templateMethod(){
        //调用基本方法
        abstractMethod();
        doItWithYou();
        concreteMethod();
    }
    /**
     * 基本方法的声明（由子类实现）
     */
    protected abstract void abstractMethod();
    /**
     * 基本方法(空方法),hookMethod,默认有空实现，
     */
    protected void doItWithYou(){

    }

    /**
     * 基本方法（已经实现）
     */
    private final void concreteMethod(){
        //业务相关的代码
        System.out.println("AbstractTemplate::concreteMethod");
    }
}
