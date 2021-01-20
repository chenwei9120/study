package com.bit.basic;

import java.math.BigDecimal;

public class DigitFormat {
    public static void main(String[] args) {
//        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
//        System.out.println(df.format(123.4567890));
//        double d = 123.4567890;
//        System.out.println(format(d, 3));
//        BigDecimal a1 = BigDecimal.valueOf(74505);
//        BigDecimal a2 = BigDecimal.valueOf(98173);
//        System.out.println(a1.divide(a2, 5, BigDecimal.ROUND_HALF_UP));


        BigDecimal bd =  BigDecimal.valueOf(100);
        BigDecimal bd2 =  BigDecimal.valueOf(3);
        BigDecimal result = bd.divide(bd2, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
    }

    public static double format(double origin, int digit) {
        BigDecimal b = new BigDecimal(origin);
        return b.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
