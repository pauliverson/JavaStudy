package com.hjy.LearnStudy.JavaStudy.NetEase;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-21 17:12
 */
public class Class1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNextInt()) {

            int a = in.nextInt();
            int b = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int sum = 0;
            while (a < b) {
                a = a + p;
                if (a >= b) {
                    sum++;
                }
                else {
                    a = a - p;
                    p = p * q;
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
