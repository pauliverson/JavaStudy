package com.hjy.LearnStudy.JavaStudy.NetEase.HuYu;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-27 19:07
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int numbers[] = countOneToNiNumber(a, b);
            list.add(numbers);
            for (int j = 1; j <= 9; j++) {
                System.out.print(numbers[j]);
                if (j != 9) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        int maxIndex = 0;
        int max = 0;
        for (int i = 1; i <= 9; i++) {
            int nowMax = 0;
            for (int j = 0; j < list.size(); j++) {
                nowMax += list.get(j)[i];
            }
            if (nowMax > max) {
                maxIndex = i;
                max = nowMax;
            }
        }
        System.out.println(maxIndex);
    }

    public static int[] countOneToNiNumber(int a, int b) {
        int numbers[] = new int[10];
        int tempA = a;
        int tempB = b;
        while (tempA != 0) {
            numbers[tempA % 10]++;
            tempA /= 10;
        }
        while (tempB != 0) {
            numbers[tempB % 10]++;
            tempB /= 10;
        }
        tempA = a;
        tempB = b;
        while (tempB != 0) {
            int tempNumber = (tempB % 10) * tempA;
            while (tempNumber != 0) {
                numbers[tempNumber % 10]++;
                tempNumber /= 10;
            }
            tempB /= 10;
        }
        int Number = a * b;
        while (Number != 0) {
            numbers[Number % 10]++;
            Number /= 10;
        }

        return numbers;
    }

}
