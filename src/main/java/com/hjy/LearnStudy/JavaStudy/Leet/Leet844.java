package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Stack;

public class Leet844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#b#", "ab#"));
    }
    public static boolean backspaceCompare(String S, String T) {
        return stringParse(S).equals(stringParse(T));
    }
    public static String stringParse(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static boolean backspaceCompareOfTwoPointer(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
