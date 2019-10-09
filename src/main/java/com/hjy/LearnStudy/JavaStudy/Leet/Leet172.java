package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-07 09:17
 */
public class Leet172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            System.out.println(n/5);
            n /= 5;
        }
        return res;
    }
}
