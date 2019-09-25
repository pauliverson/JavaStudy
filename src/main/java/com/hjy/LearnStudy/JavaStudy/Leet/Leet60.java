package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @program test
 * @description LeetCode60
 * @date 2019-08-20 01:03
 */
public class Leet60 {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 8));
    }

    public static String getPermutation(int n, int k) {

        String res = "";
        String number = "123456789";

        int f[] = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * i;
        }

        k = k - 1;

        for (int i = n; i >= 1; i--) {
            int a = k / f[i - 1];
            k = k % f[i - 1];
            res += number.charAt(a);
            number = number.substring(0, a) + number.substring(a + 1);
        }
        return res;
    }
}
