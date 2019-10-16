package com.hjy.LearnStudy.JavaStudy.TongCheng;

import java.util.Scanner;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-13 20:29
 */
public class Class3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int dp[] = new int[m];
        if (m == 1) {
            System.out.println(1);
            return;
        }
        if (m == 2) {
            System.out.println(2);
            return;
        }

        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < m; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[m - 1]);
    }
}
