package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Arrays;

/**
 * @author huangjunyan
 * @program test
 * @description LeetCode59
 * @date 2019-08-21 00:22
 */
public class Leet59 {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, val = 1;
        while (val <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = val++;
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = val++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                matrix[down][i] = val++;
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = val++;
            }
            if (++left > right) break;
        }
        return matrix;
    }
}
