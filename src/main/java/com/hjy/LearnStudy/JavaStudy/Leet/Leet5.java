package com.hjy.LearnStudy.JavaStudy.Leet;

import com.didi.mybatis.demo.entity.UserModel;

/**
 * @author huangjunyan
 * @date 2019-07-11 18:02
 */
public class Leet5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdbbfcba"));

    }
    public static String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder("$");
        for(int i = 0;i < s.length();i++) {
            stringBuilder.append("#");
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append("#");
        int mx = 0,id = 0;
        int start = 0,maxLen = 0;
        String str = stringBuilder.toString();
        int[] p = new int[str.length()];
        for(int i = 1;i < str.length();i++) {
            p[i] = i < mx ? Math.min(p[2*id-i],mx-i) : 1 ;
            while(i + p[i] < str.length() && str.charAt(i+p[i]) == str.charAt(i-p[i])) {
                p[i] ++;
            }
            if(i + p[i] > mx) {
                id = i;
                mx = i + p[i];
            }
            if(p[i] - 1 > maxLen) {
                start = (i-p[i])/2;//因为原字符串中没有这些特殊符号，／2找到之前的位置
                maxLen = p[i] - 1;

            }
        }
        System.out.println(start +"  "+ maxLen);
        return s.substring(start,start+maxLen);
    }
}
