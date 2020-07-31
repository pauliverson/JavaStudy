package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Stack;

public class Leet394 {
    public static void main(String[] args) {
        System.out.println(decodeString("adsf2[a2[cd]]"));
    }
    public static String decodeString(String s) {
        StringBuilder resDecode = new StringBuilder();
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int multi = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '[') {
                numberStack.push(multi);
                charStack.push(resDecode.toString());
                multi = 0;
                resDecode = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = numberStack.pop();
                for (int i = 0;i < cur_multi; i++) {
                    tmp.append(resDecode);
                }
                resDecode = new StringBuilder(charStack.pop() + tmp);
            } else if (ch >= '0' && ch <= '9') {
                multi = ch - '0';
            } else {
                resDecode.append(ch);
            }
        }
        return resDecode.toString();
    }
}
