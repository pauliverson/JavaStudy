package com.hjy.LearnStudy.JavaStudy.Baidu;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-17 20:00
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
//        long[][] array = new long[n+1][m+1];
        int max = Math.max(m, n);
        long down = k / max;
        int min = Math.min(m, n);

        System.out.println(min - down);
    }
}

