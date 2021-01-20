package com.bit.basic.closure;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Outer.java
 * @Description TODO
 * @createTime 2020年04月11日 23:39:00
 */
public class Outer {
    public AnonInner getAnonInner(final int x) {
        final int y = 5;
        return new AnonInner() {
            @Override
            public int add() {
                return x + y;
            }
        };
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        AnonInner inner = outer.getAnonInner(100);
        System.out.println(inner.add());
    }
}