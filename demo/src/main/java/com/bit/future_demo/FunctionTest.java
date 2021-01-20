package com.bit.future_demo;

import org.springframework.cglib.core.internal.Function;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName FunctionTest.java
 * @Description TODO
 * @createTime 2019年12月17日 09:56:00
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.test();
    }

    public void test() {
        Function<Object, Integer> converter = (object) -> {
            // logic
            if (object == null) {
                return null;
            }
            try {
                return Integer.valueOf(object.toString());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
        System.out.println(converter.apply("12345"));
    }
}