package com.hjy.LearnStudy.JavaStudy.HuaWei.Algrithom;

import java.util.Scanner;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-25 19:08
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String input = in.nextLine();
            String inputs[] = input.split(" ");
            if (inputs[0].equals("U")) {
                int point = Integer.parseInt(inputs[1]);
                int add = Integer.parseInt(inputs[2]);
                nums[point - 1] += add;
            }else {
                int start = Integer.parseInt(inputs[1]);
                int end = Integer.parseInt(inputs[2]);
                int sum = 0;
                for (int j = start - 1; j <= end - 1; j++) {
                    sum += nums[j];
                }
                System.out.println(sum/(end - start + 1));
            }
        }
    }
}
