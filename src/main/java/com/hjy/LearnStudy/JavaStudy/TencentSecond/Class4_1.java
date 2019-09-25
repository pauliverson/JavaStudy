package com.hjy.LearnStudy.JavaStudy.TencentSecond;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 21:32
 */
import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 20:48
 */
public class Class4_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        long maxRes = 0;
        int i = 0;
        while (i <= n - 1) {
            long sum = w[i];
            long res = 0;
            int left = i - 1;
            int right = i + 1;
            while (right <= n - 1 && w[right] >= w[i]) {
                sum += w[right];
                right++;
            }
            while (left >= 0 && w[left] >= w[i] ) {
                sum += w[left];
                left --;
            }
            res = sum * w[i];
            maxRes = Math.max(res, maxRes);
            if (right == n) {
                i++;
            }
            else if (w[right] > w[i]) {
                i = right;
            }else {
                i++;
            }
        }
        System.out.println(maxRes);
    }
}

