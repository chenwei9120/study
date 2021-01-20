package com.bit;

import com.rabbitmq.tools.json.JSONUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IP {
    public static void main(String[] args) {
//        try {
//            String ip = InetAddress.getLocalHost().getHostAddress();
//            System.out.println(ip);
//        } catch (UnknownHostException e) {
//            System.out.println(e.getMessage());
//        }
//        List<Test> a = new ArrayList<>();
//        a.add(new Test(12, "Jim"));
//        a.add(new Test(1, "Tom"));
//        a.add(new Test(123, "Law"));
//        a.add(new Test(64, "Jason"));
//        a.sort(Comparator.comparing( Test::getId));
//        a.forEach(t -> System.out.println(t.getId()));

        try {
            BigDecimal rs = new BigDecimal("27.333");
            rs = rs.setScale(2);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
