package com.bit.basic;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CallableTest.java
 * @Description TODO
 * @createTime 2019年10月30日 15:30:00
 */
public class Test {
    public static void main(String[] args) throws ParseException {



//        String s = "1,2,3";
//        System.out.println(s.contains("3"));


//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        list.add(4L);
//        list.add(5L);
//        list.add(6L);
//        list.add(7L);
//        list.add(8L);
//        list.add(9L);
//        list.add(10L);
//        list.add(11L);
//        list.add(12L);
//        list.add(13L);
//        list.add(14L);
//        list.add(15L);
//        list.add(16L);
//        list.add(17L);
//        list.add(18L);
//        list.add(19L);
//        list.add(20L);
//        list.subList(0, 10).stream().forEach(i->System.out.println(i));
//        System.out.println("--------------------------------------------------------------------");
//        list.subList(10, 20).stream().forEach(i->System.out.println(i));
//        System.out.println(list.subList(20 ,20).size());
//        String strStartDate = "2019-10-20";
//        String strEndDate = "2019-10-23";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse(strStartDate);
//        Date endDate = sdf.parse(strEndDate);
//        System.out.println(startDate.getTime());
//        System.out.println(endDate.getTime());
//        List<Student> studentList = new ArrayList<>();
//        Student student = new Student();
//        student.setId(0L);
//        student.setName("李雷");
//        studentList.add(student);
//        student.setId(1L);
//        student.setName("韩梅梅");
//        studentList.add(student);
//        studentList.forEach(student1 -> System.out.println("id=" + student1.getId() + ";name=" + student1.getName()));

//        Long _version2 = 1L;
//        if(_version2 == version) {
//            System.out.println("====");
//        } else {
//            System.out.println("!!==");
//        }

       //Class<T> clazz = Class.forName("");

//        List<Integer> list = new ArrayList<>();
//        for(Integer i : list) {
//            System.out.println(i);
//        }

//        list.add(1);
//        list.add(345);
//        if(list.contains(3)) {
//            System.out.println("ddd");
//        }else {
//            System.out.println("eeee");
//        }

        //System.out.println(CallableTest.class.getResource("/"));
    }
    public static Long version = 1L;

    public static class Student {
        Long id;
        String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}