package com.hjy.LearnStudy.JavaStudy.DiDi;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-19 20:21
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int min = Integer.MAX_VALUE;

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        while (m - 1 < n) {
            int start = 0;
            int end = m - 1;
            while (end < n) {
                int temp = 0;
                for (int j = start; j <= end; j++) {
                    temp += array[j];
                }
                min = Math.min(min, temp);
                start++;
                end++;
            }
            m++;
        }
        System.out.println(min);
    }
}
