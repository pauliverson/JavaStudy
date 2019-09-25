package com.hjy.LearnStudy.JavaStudy.TencentSecond;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 19:56
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        int oddInA = 0, evenInA = 0;
        int oddInB = 0, evenInB = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] % 2 == 0) {
                evenInA ++;
            }else {
                oddInA++;
            }
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            if (b[i] % 2 == 0) {
                evenInB ++;
            } else {
                oddInB ++;
            }
        }
        System.out.println(Math.min(evenInA, oddInB)+Math.min(oddInA, evenInB));

    }
}
