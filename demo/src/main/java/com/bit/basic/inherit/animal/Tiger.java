package com.bit.basic.inherit.animal;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Tiger.java
 * @Description TODO
 * @createTime 2019年12月13日 22:38:00
 */
public class Tiger extends Animal {

    public Tiger() {//主要看父类没有无参构造时，一定要初始化父类构造参数
       super("tiger");
    }

    @Override
    public void eat() {
        System.out.println("Tiger::eat");
    }
}