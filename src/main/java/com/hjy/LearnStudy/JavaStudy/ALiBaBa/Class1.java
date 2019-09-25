package com.hjy.LearnStudy.JavaStudy.ALiBaBa;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-30 19:49
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }
    private static int getMinimumTimeCost(int n, int[][] area) {
        return 0;
    }
}
