package com.hjy.LearnStudy.JavaStudy.DiDi;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-19 19:40
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int first = in.nextInt();
            int second = in.nextInt();

            matrix[first][second] = 1;
        }


    }
}
