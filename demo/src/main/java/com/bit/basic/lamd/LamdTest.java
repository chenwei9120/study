package com.bit.basic.lamd;

import com.alibaba.fastjson.JSON;
import com.bit.conditon.B;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LamdTest {

    public static void main(String[] args) {
//        BigDecimal d1 = new BigDecimal(10);
//        BigDecimal d2 = new BigDecimal(3);
//        System.out.println(d1.divide(d2, 1, RoundingMode.HALF_UP));

//        String s="hello"; String t="hello"; char c[]={'h','e','l','l','o'};
//        System.out.println(s.equals(t));
//        System.out.println(t.equals(new String(c)));
//        System.out.println(s==t);
//        System.out.println(t==new String(c));
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        Date date = new Date(calendar.getTimeInMillis());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));

//        Date now = new Date();
//        System.out.println(now.getYear());
//        System.out.println(now.getMonth());
//        Date firstDay = new Date(now.getYear(), now.getMonth(), 1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date newDate = new Date(firstDay.getTime());
//        System.out.println(sdf.format(newDate));

//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date firstDay = new Date(now.getYear(), now.getMonth(), 1);
//        Date day = new Date(now.getYear(), now.getMonth() + 1, 1);
//        Date lastDay = DateUtils.addDays(day, -1);
//        System.out.println(sdf.format(lastDay));
//        String s = "213.4";
//        BigDecimal big = new BigDecimal(s);
//        System.out.println(big);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d = new Date(1602691200000L);
//        System.out.println(sdf.format(d));

//        BigDecimal bigDecimal = new BigDecimal(0);
//        bigDecimal = bigDecimal.add(new BigDecimal(123));
//        System.out.println(bigDecimal);

//        int[] b = .sorted().toArray();
        //       Arrays.stream(b).forEach(x-> System.out.println(x));
        reduce3();
//        optionTest();
//        flatMapTest2();
    }


    static void flatMapTest() {
        List<KlassGroup> groupList = Arrays.asList(
                new KlassGroup(new Klass(1), new Klass(2), new Klass(3)),
                new KlassGroup(new Klass(4), new Klass(5), new Klass(6)),
                new KlassGroup(new Klass(7), new Klass(8), new Klass(9)),
                new KlassGroup(new Klass(10))
        );

        List<List<Klass>> result = groupList.stream()
                .map(it -> it.getKlassList())
                .collect(Collectors.toList());
        result.stream().forEach(x ->
                x.stream().forEach(y -> System.out.println(y + "   ")));
        List<Klass> result3 = groupList.stream()
                .flatMap(it -> it.getKlassList().stream())
                .collect(Collectors.toList());
        result3.forEach(x -> System.out.println(JSON.toJSONString(x.field)));
    }

    static void flatMapTest2() {
        String[] names = new String[]{"Michael Kern", "Frank Underwood"};
        Arrays.stream(names).flatMap(x -> Stream.of(x.split(" "))).forEach(System.out::println);
    }

    static void reduce1() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce((a, b) -> {
            System.out.println("a=" + a + ",b=" + b);
            return a + b;
        }).get();
        System.out.println(result);
    }

    static void reduce2() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce(-1, (a, b) -> {
            System.out.println("a=" + a + ",b=" + b);
            return a + b;
        });
        System.out.println(result);
    }

    //如果你使用了parallelStream reduce操作是并发进行的
    //为了避免竞争 每个reduce线程都会有独立的result combiner的作用在于合并每个线程的result得到最终结果;
    //第三个参数combiner主要是使用在并行计算的场景下；如果Stream是非并行时，第三个参数实际上是不生效的。
    static void reduce3() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int result = numList.stream().reduce(
        int result = numList.parallelStream().reduce(
                -1, (a, b) -> {
                    System.out.println("a=" + a + ",b=" + b);
//                    System.out.println("Thread id = " + Thread.currentThread().getId());
                    return a + b;
                }, (a1, b1) -> {
//                    System.out.println("Thread id = " + Thread.currentThread().getId());
                    System.out.println(String.format("a1=%d,b1=%d", a1, b1));
                    return a1 + b1;
                }
        );
        System.out.println(result);
    }

    static void sort1() {
        List<Integer> numList = Arrays.asList(1, 5, 7, 6, 9);
        numList.stream().sorted(Comparator.comparing(x -> x)).forEach(x -> System.out.println(x));
        //numList.sort((x, y) -> y - x > 0 ? 1 : -1);
    }


    static void lamd1() {
        String[] nameArray = {"hujian", "libai", "hujian", "hibei", "wanganshi"};

        Stream.of(nameArray)
                .parallel()
                .distinct()
                .filter(s -> s.startsWith("h"))
                .map(String::toUpperCase)
                //.collect(Collectors.toCollection(ArrayList::new))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void optionTest() {
        String[] nameArray = {"William", "David", "Frank", "Jim", "Peter"};
        Boy boy = new Boy();
        //Stream.of(nameArray).filter(s -> s.equals("William")).findFirst().ifPresent(x -> boy.setName(x));
        /*
        从上面optional为空值和有值的情况的例子可以看到orElse在不论optional有没有值的时候都会执行，
        在optional为空值的情况下orElse和orElseGet都会执行，当optional不为空时，orElseGet不会执行。
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

        //String name = Stream.of(nameArray).filter(s -> s.equals("William")).findFirst().orElse("Tom");
        String name = Stream.of(nameArray).filter(s -> s.equals("William")).findFirst().orElseGet(() -> "Tom");
        System.out.println(name);
    }

    public static void mapTest() {
//        Stream<String> stream = Stream.of("a", "b", "c", "d");
//        stream.map(String::toUpperCase).forEach(System.out::println);//map可以返回集合操作结果.foreach和peek都不能返回结果
        List<Lunch> list = new ArrayList();
        list.add(new Lunch());
        list.add(new Lunch());
        list.add(new Lunch());
        List<Apple> appleList = new ArrayList<>();
        list.stream().forEach(l -> appleList.add(l.getApple()));//foreach无法改成map
        appleList.stream().forEach(System.out::println);
    }

    public static void peekTest() {
        //Stream<String> stream = Stream.of("a", "b", "c", "d");
        //IntStream stream = IntStream.range(1, 20).peek(n ->  n = 2* n);n = 2* n的计算结果没有返回到stream里
//        int[] array = IntStream.range(1, 20).peek(n ->  n = 2* n).toArray();
//        Arrays.stream(array).forEach(a -> System.out.print(a + "\t"));
    }

    static void lamd2() {
        int sum = IntStream.range(1, 20)
                //     .parallel()
                .skip(5)
//                .limit(5)
                .peek(n -> System.out.print(n + "\t"))

                .sum();
        System.out.println("sum is :" + sum);
    }

    static void lamd3() {
        //Arrays.stream(IntStream.range(1, 20).toArray()).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> list = null;
//        numbers.parallelStream()
//                .forEach(System.out::println);
        numbers.stream().parallel().forEach(x -> {
                    list.add("ccccccc");
                }
        );
    }

    public static void toMapTest() {
        List<EquipmentPoint> equipmentPointList = new ArrayList<>();
        EquipmentPoint equipmentPoint = new EquipmentPoint();
        equipmentPoint.setId(1);
        equipmentPoint.setMetricCode("202011160001");
        equipmentPointList.add(equipmentPoint);

        equipmentPoint = new EquipmentPoint();
        equipmentPoint.setId(2);
        equipmentPoint.setMetricCode("202011160002");
        equipmentPointList.add(equipmentPoint);

        equipmentPoint = new EquipmentPoint();
        equipmentPoint.setId(1);
        equipmentPoint.setMetricCode("202011160001");
        equipmentPointList.add(equipmentPoint);
//        Map<Long, EquipmentPoint> hashMap = equipmentPointList.stream().collect(Collectors.toMap(EquipmentPoint::getId, Function.identity()));
//        for (Long key : hashMap.keySet()) {
//            System.out.println(JSON.toJSON(hashMap.get(key)));
//        }
    }

    @Data
    private static class EquipmentPoint {
        /**
         * point标识
         */
        private int id;

        /**
         * point名称 数据项名称
         */
        private String name;

        /**
         * 监控项编码
         */
        private String metricCode;
    }

    private static class Lunch {
        public Lunch() {
            apple = new Apple();
        }

        private Apple apple;

        public Apple getApple() {
            return apple;
        }

        public void setApple(Apple apple) {
            this.apple = apple;
        }
    }

    private static class Apple {

    }

    private static class Klass {
        private int field;

        public Klass(int field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return "field=" + field;
        }
    }

    private static class KlassGroup {
        private List<Klass> group = new ArrayList<>();

        public KlassGroup(Klass... objList) {
            for (Klass item : objList) {
                this.group.add(item);
            }
        }

        public List<Klass> getKlassList() {
            return group;
        }
    }

    @Data
    private static class Boy {
        private String name;
    }
}
