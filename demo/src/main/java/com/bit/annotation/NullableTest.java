package com.bit.annotation;

import org.springframework.lang.NonNull;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName NullableTest.java
 * @Description TODO
 * @createTime 2020年03月02日 21:42:00
 */
//@NonNull可以标注在方法、字段、参数之上，表示对应的值不可以为空
//@Nullable注解可以标注在方法、字段、参数之上，表示对应的值可以为空
public class NullableTest {

    public static void main(String[] args) {
        NullableTest nullableTest = new NullableTest();
        nullableTest.test();
    }

    void test() {
        capitalize(null);
    }
    String capitalize(@NonNull String in) {
        return in.toUpperCase();                // no null check required
    }
    void caller(String s) {
        if (s != null)
            System.out.println(capitalize(s));  // preceding null check is required
    }
}