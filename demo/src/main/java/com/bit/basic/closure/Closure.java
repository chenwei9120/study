package com.bit.basic.closure;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Closure.java
 * @Description 闭包
 * 闭包是指有权访问另一个函数作用域中的变量的函数。
 * @createTime 2020年04月11日 23:17:00
 */
public class Closure {
    private static  int a = 100;

    public static void main(String[] args) {
        InternalClass internalClass = new InternalClass();
        System.out.println(internalClass.add());
    }

    private static class InternalClass {
        public String add() {
            int val = 100;
            return String.format("结果=%d", val + 1);
        }
    }
}