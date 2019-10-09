package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-06 22:34
 */
public class Leet171 {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int nowNumber =(int) (s.charAt(i) - 'A' + 1);
            res += nowNumber * Math.pow(26, s.length() - 1 - i);
        }
        return res;
    }
}
