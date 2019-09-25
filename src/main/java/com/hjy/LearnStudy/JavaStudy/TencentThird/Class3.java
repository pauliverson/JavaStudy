package com.hjy.LearnStudy.JavaStudy.TencentThird;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-20 20:50
 */
public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int m = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int point = 0;
        int temp = 0;
        while (point <= m) {
            if (arr[arr.length - 1] == 0) {
                System.out.println(0);
                point++;
                continue;
            }
            if (arr[point] == 0) {
                point++;
                m++;
                continue;
            }
            System.out.println(arr[point] - temp);
            temp += arr[point] - temp;
            point++;
            while(point != n && arr[point] - temp == 0) {
                arr[point] -= temp;
                point++;
            }

        }
//        for (int i = 0; i < m; i++) {
//            if (arr[i] - temp > 0) {
//                System.out.println(arr[i] - temp);
//                temp += arr[i] - temp;
//            }else {
//                continue;
//            }
//        }
    }
}
