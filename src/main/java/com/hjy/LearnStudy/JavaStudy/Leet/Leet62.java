package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-22 00:35
 */
public class Leet62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        int sum = m + n - 2;
        int k = n - 1;

        long up = 1;
        long down = 1;

        for (int i = k; i >= 1; i--) {
            up *= sum;
            down *= i;
            sum -= 1;
        }

        return (int) (up / down);
    }
}
