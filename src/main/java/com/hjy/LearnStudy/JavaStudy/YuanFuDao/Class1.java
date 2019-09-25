package com.hjy.LearnStudy.JavaStudy.YuanFuDao;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-24 16:31
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int max = scanner.nextInt();

        int[] callArray = new int[n];

        for (int i = 0; i < callArray.length; i++) {
            callArray[i] = scanner.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : callArray) {
            int count = map.getOrDefault(num,0);
            map.put(num, ++count);
        }

        for (int i = 0; i < callArray.length; i++) {
            int now = callArray[i];
            if (map.get(now) <= max) {
                System.out.print(now + " ");
            }
        }

    }
}
