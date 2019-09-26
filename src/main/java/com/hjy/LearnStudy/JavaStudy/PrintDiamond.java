package com.hjy.LearnStudy.JavaStudy;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-25 18:15
 */
public class PrintDiamond {
    public static void main(String[] args) {
        //边长，为双数则长度+1，奇数则就是输入的长度
        printDiamond(5);
    }

    public static void printDiamond(int size) {
        int n = size;
        for (int i = 0; i <= n; i+=2) {
            for (int j = n; j > i; j-=2) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = (n - 1) % 2 == 0 ? n-3 : n-2; i >= 0;i -= 2) {
            for (int j = n; j > i; j-=2) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
