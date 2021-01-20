package com.bit.spi;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ExcelParse.java
 * @Description TODO
 * @createTime 2020年03月02日 11:16:00
 */
public class ExcelParse implements IParseDoc {


    static {
        System.out.println("ExcelParse Construct.");
        a = 100;
        //System.out.println(a);无法访问静态模块之后定义的类变量
    }

    static int a;

    @Override
    public void parse() {
        System.out.println("解析 excel");
    }
}