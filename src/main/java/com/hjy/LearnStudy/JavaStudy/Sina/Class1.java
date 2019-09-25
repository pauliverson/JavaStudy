package com.hjy.LearnStudy.JavaStudy.Sina;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-31 16:55
 */
public class Class1 {
    public static void main(String[] args) {

    }
    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        int minIndex = 0;
        for (int i = 0; i < list.length; i++) {
            if (compareVersion(list[i],list[minIndex])) {
                minIndex = i;
            }
        }
        return list[minIndex];
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
