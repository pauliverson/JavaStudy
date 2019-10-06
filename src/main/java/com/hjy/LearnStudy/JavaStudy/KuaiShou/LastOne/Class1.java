package com.hjy.LearnStudy.JavaStudy.KuaiShou.LastOne;

import java.util.*;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-28 19:57
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        in.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }
        int[] score = new int[m];
        for (int i = 0; i < m; i++) {
            score[i] = in.nextInt();
        }

        int scoreNum = 0;
        Map<Character, Integer> map;
        for (int i = 0; i < m; i++) {
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(list.get(j).charAt(i))) {
                    map.put(list.get(j).charAt(i), 1);
                } else {
                    int num = map.get(list.get(j).charAt(i));
                    map.put(list.get(j).charAt(i), ++num);
                }
            }
            score[i] = score[i] * (map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue());
            scoreNum += score[i];
        }

        System.out.println(scoreNum);
    }
}
