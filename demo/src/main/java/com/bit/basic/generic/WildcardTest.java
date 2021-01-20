package com.bit.basic.generic;

import com.bit.basic.exception.App;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName WildcardTest.java
 * @Description TODO
 * @createTime 2020年04月22日 16:44:00
 */
public class WildcardTest {

    public static void test1(Box<?> box) {
        //System.out.println(box.get());
    }

    public static <T> void test2(Box<T> box) {
        //System.out.println(box.get());
    }

    public static void main(String[] args) {
        //Box<Apple> box = new Box<Apple>() {};
//        Box<Apple> box = new Box();
//        Type type = ((ParameterizedType) box.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        System.out.println(type);

//        box.put(new Apple());
//        test1(box);
//        test2(box);
        List<String> list = new ArrayList<String>() {
        };
//        Type type = ((ParameterizedType) list.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//         System.out.println(type);

    }

//    static class Box<T> {
//        private T element;
//        public Box() {
//            System.out.println("Box()");
//        }
//        public T get() {
//            System.out.println(element.getClass());
//            return element;
//        }
//
//        public void put(T element) {
//            this.element = element;
//        }
//
//        public Class<T> getTClass() {
//            Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//            return tClass;
//        }
//    }

    static class Box<T> {

    }
}