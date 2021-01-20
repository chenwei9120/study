package com.bit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("Name", "Way");
//        Object object = map.get("Name");
        //System.out.println(2<<1);
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < 17; ++i) {
            map.put(i,i);
        }
//        List<Long> list1 = new ArrayList<>();
//        list1.add(1L);
//        list1.add(2L);
//        List<Long> list2 = new ArrayList<>();
//        list1.add(2L);
//        list1.add(3L);
//
//
//        HashSet hashSet = new HashSet();
//        hashSet.add(list1);
//        hashSet.add(list2);
//        hashSet.stream().forEach(l -> System.out.println(l));
    }
}
