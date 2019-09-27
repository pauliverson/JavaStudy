package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.HashMap;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-27 12:29
 */
public class Leet166 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,3));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long reminder = dividend % divisor;
        fraction.append(dividend / divisor);
        if (dividend % divisor == 0) {
            return fraction.toString();
        }

        fraction.append(".");
        //应用map来记录余数的值，并记录当前的余数的位置
        HashMap<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                fraction.insert(map.get(reminder), "(");
                fraction.append(")");
                break;
            }
            map.put(reminder, fraction.length());
            reminder = reminder * 10;
            fraction.append(reminder / divisor);
            reminder = reminder % divisor;
        }

        return fraction.toString();
    }
}
