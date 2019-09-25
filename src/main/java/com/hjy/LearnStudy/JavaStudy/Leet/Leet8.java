package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-25 11:30
 */
public class Leet8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
    public static int myAtoi(String str) {
        long res = 0L;
        int index = 0;
        int sign = 1;
        if(str == null)
            return 0;

        if(str.charAt(index) == '-' || str.charAt(index) == '+') {
            if(str.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        for(;index < str.length();index++) {
            if(str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            res = res*10 + (str.charAt(index)-'0');
            if(res >= Integer.MAX_VALUE)
                break;
        }
        if(res * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(res * sign >= Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)res*sign;
    }
}
