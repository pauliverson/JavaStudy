package com.hjy.LearnStudy.JavaStudy.WeBank;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-19 16:37
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long res = fun1(n);
        while (res % 10 == 0) {
            res = res / 10;
        }

        System.out.println(res % 10);
    }


    public static long fun1(int n) {
        if (n <= 1)
            return 1;
        long[] nums = new long[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            long now = i * nums[i - 1];
            while (now % 10 == 0) {
                now = now / 10;
            }
            nums[i] = now % 10 + ((now / 10) % 10) * 10 + ((now / 100) % 10) * 100;
        }
        return nums[n];
    }

}
