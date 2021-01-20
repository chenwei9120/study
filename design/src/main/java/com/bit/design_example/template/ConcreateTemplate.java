package com.bit.design_example.template;

public class ConcreateTemplate extends AbstractTemplate {

    @Override
    protected void abstractMethod() {
        System.out.println("ConcreateTemplate::abstractMethod");
    }

//    根据需要看是否需要覆父类方法
//    @Override
//    public void  doItWithYou(){
//        System.out.println("ConcreateTemplate::doItWithYou");
//    }

    public static void main(String[] args) {
        ConcreateTemplate concreateTemplate = new ConcreateTemplate();
        concreateTemplate.templateMethod();
    }
}
