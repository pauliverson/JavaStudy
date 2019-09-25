package com.hjy.LearnStudy.JavaStudy.HuaWei;

import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-18 19:01
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        input = input.toLowerCase();
//        input.replace(' ', '0');
        StringBuilder sb = new StringBuilder();
        int len = input.length() - 1;
        for (int i = len; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                sb.append("0");
            }
            else {
                sb.append(input.charAt(i));
            }
        }

//        sb.reverse();

        System.out.println(sb.toString());
    }
}
