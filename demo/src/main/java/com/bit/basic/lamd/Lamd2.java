package com.bit.basic.lamd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Lamd2 {

    public static void main(String[] args) {
        int a[] = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        //Arrays.fill(a, 1);
        stream(a).filter(b->b%2==0).forEach(System.out::println);
        System.out.println(stream(a).filter(b->b%2==0).count());

        Country countries[] = new Country[5];
        countries[0] = new Country();
        countries[1] = new Country();
        countries[2] = new Country();
        countries[3] = new Country();
        countries[4] = new Country();
        countries[0].setName("China");
        countries[1].setName("Japan");
        countries[2].setName("German");
        countries[3].setName("America");
        countries[4].setName("Japan");
        countries[0].setContinent("Asia");
        countries[1].setContinent("Asia");
        countries[2].setContinent("Europe");
        countries[3].setContinent("America");
        countries[4].setContinent("Asia");
        Map<String, List<Country>> map = stream(countries).collect(Collectors.groupingBy(c->c.getContinent()));
        map.get("Asia").stream().distinct().forEach(System.out::println);

        List<Apple> appleStrore = new ArrayList<>();
        appleStrore.add(new Apple(1,"red", 500, "山东"));
        appleStrore.add(new Apple(2,"red", 400, "山东"));
        appleStrore.add(new Apple(3,"green", 450, "山东"));
        appleStrore.add(new Apple(4,"green", 600, "天津"));
        appleStrore.add(new Apple(5,"green", 400, "天津"));
//        Map<String, Double> collect =  appleStrore.stream().collect(
//               Collectors.groupingBy(c->c.getColor(), Collectors.averagingInt(c->c.getWeight())));
//        collect.forEach((k, v) -> System.out.println(k + ":" + v));
        appleStrore.stream().collect(
                Collectors.groupingBy(c->c.getColor(), Collectors.averagingInt(c->c.getWeight())))
                .forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
