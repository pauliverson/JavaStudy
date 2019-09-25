package com.hjy.LearnStudy.JavaStudy.TencentSecond;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 20:48
 */
public class Class4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        long maxRes = 0;
        for (int i = 0; i < n; i++) {
            long sum = w[i];
            long res;
            int left = i - 1;
            int right = i + 1;
            while (right <= n - 1 && w[right] >= w[i]) {
                sum += w[right];
                right ++;
            }
            while (left >= 0 && w[left] >= w[i] ) {
                sum += w[left];
                left --;
            }
            res = sum * w[i];
            System.out.println(w[i] + " " + res);
            maxRes = Math.max(res, maxRes);
            if (right == n) {
                continue;
            }
        }
        System.out.println(maxRes);
    }
}


