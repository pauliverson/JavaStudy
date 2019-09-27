package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-27 16:47
 */
public class Leet168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            char now;
            if (n % 26 == 0) {
                now = (char) (90);
                n = n / 26 - 1;
            }else {
                now = (char) (65 + n % 26 - 1);
                n = n / 26;
            }
            sb.append(now);

        }

        return sb.reverse().toString();
    }
}
