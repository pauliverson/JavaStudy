package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-08-06 00:11
 */
public class Leet58 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i = chars.length-1;i>=0;i++) {
            if(chars[i] != ' ') {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
}
