package com.hjy.LearnStudy.JavaStudy.Baidu;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-17 20:48
 */
public class Class2 {
    static class Vector {
        int val;
        Vector next;
        public Vector(int x, int nextVal) {
            this.val = x;
            next.val = nextVal;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Map<Integer, Set> map = new HashMap<>();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int first = in.nextInt();
                int second = in.nextInt();
                Set set = map.getOrDefault(second, new HashSet());
                set.add(first);
                map.put(second, set);
            }
            if (map.get(n).contains(1)) {
                System.out.println("POSSIBLE");
                continue;
            }
            for (Object num : map.get(n)) {

            }
        }
    }
}
