package com.hjy.LearnStudy.JavaStudy.TencentThird;

import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String t = in.nextLine().trim();
        while (in.hasNextLine()) {
            int len = Integer.valueOf(in.nextLine().trim());
//            System.out.println(len);
            String number = in.nextLine().trim();

            System.out.println(check(len, number));
        }

    }
    public static String check(int len, String number) {
        if (len < 11) {
            return "NO";
        }
        else {
            Integer index = number.indexOf("8");
            if (index == -1) {
                return "NO";
            } else {
                int left = len - index;
                if (left < 11) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
