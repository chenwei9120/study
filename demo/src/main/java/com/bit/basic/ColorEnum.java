package com.bit.basic;

import java.util.Arrays;

public enum ColorEnum {
    Red, Brown, Bule, Yellow, Green, Black, White, Pink;

    public static void main(String[] args) {
        System.out.println(ColorEnum.Brown.getClass());
        Arrays.stream(ColorEnum.values()).forEach(System.out::println);
    }
}

