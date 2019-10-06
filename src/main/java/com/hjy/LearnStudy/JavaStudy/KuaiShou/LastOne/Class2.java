package com.hjy.LearnStudy.JavaStudy.KuaiShou.LastOne;

import sun.nio.ch.sctp.SctpNet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-28 20:05
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(getSubSet(s, k));
    }
    public static long getSubSet(String str, int k) {
        if (str.equals("")) {
            return 0;
        }
        long count = 0;
//        int start = 0, end = 0;
//        while (end < str.length()) {
//
//        }
        for (int i = 0; i < str.length(); i++) {
            int tempCount = 0;
            for (int j = i ; j< str.length(); j++) {
                if (str.charAt(j) == '1') {
                    tempCount++;
                }
                if (tempCount == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
