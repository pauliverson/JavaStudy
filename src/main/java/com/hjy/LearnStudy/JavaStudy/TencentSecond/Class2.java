package com.hjy.LearnStudy.JavaStudy.TencentSecond;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 20:15
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long[] kt = new long[n];
        long sumA = 0;
        long sumB = 0;
        for (int i = 0 ; i < n; i++) {
            a[i] = in.nextInt();
            sumA += a[i];
            b[i] = in.nextInt();
            sumB += b[i];
            kt[i] = a[i] - b[i];
        }
        long C = n*sumB - sumA;

        Arrays.sort(kt);
        long A = 0;
        for (int i = n-1; i >=0 ; i--) {
            A += kt[n- i -1] * (i+1);
        }
        System.out.println(A + C);

    }
}
