package com.bit.basic;

import java.util.ArrayList;
import java.util.List;

public class ReferTest {
    public static void main(String[] args) {
        List<String> list = null;
        addItem(list);
        list.stream().forEach(x->{
            System.out.println(x);
        });
    }


    static void addItem(List<String> list) {
        list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
    }
}
