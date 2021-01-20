package com.bit.basic.lamd;

import java.util.function.Function;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName FunctionTest
 * @Description TODO
 * @createTime 2021-01-20 13:27:00
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = s-> ++s;
        Function<Integer, Integer> g = s -> s * 2;
        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));
         */
        System.out.println(f.compose(g).apply(1));

        System.out.println("=====================================");

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(g.apply(a));
         */
        System.out.println(f.andThen(g).apply(1));

        System.out.println("=====================================");

        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println(Function.identity().apply("a"));

        System.out.println("=====================================");

    }
}
