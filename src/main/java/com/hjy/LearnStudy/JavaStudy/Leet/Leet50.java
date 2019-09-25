package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-31 23:00
 */
public class Leet50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00, -2147483648));
    }
    public static double myPow(double x, int n) {
        if(n <= Integer.MIN_VALUE)
            return 0.0;
        if(n == 0)
            return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        if(n % 2 == 0) {
            return myPow(x*x,n/2);
        }else {
            return myPow(x*x,n/2)*x;
        }
    }
}
