package com.hjy.LearnStudy.JavaStudy.Leet;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Leet784 {
    public static void main(String[] args) {
        String test = "a1b2";
        System.out.println(letterCasePermutation(test));
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
    public static void helper(char[] chars, List<String> res, int current) {
        if (current == chars.length) {
            res.add(new String(chars));
            return;
        }

        helper(chars, res, current + 1);
        if (chars[current] >= 'A') {
            chars[current] = chars[current] >= 'a' ?
                    (char) (chars[current] - 32) : (char) (chars[current] + 32);
            helper(chars, res, current + 1);

        }
    }
}
