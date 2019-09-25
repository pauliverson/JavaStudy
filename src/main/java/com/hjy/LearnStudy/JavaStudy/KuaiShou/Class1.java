package com.hjy.LearnStudy.JavaStudy.KuaiShou;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-25 17:11
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int k = 0; k < m; k++) {
            String version1 = scanner.next();
            String version2 = scanner.next();
            System.out.println(compareVersion(version1, version2));
        }
    }

    public static boolean compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return true;
            else if(i > j) return false;
        }
        return false;
    }
}
