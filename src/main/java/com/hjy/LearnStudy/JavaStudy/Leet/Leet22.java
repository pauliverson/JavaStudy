package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-25 12:05
 */
public class Leet22 {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for(String str : res) {
            System.out.println(str);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }
    public static void helper(List<String> res,String out,int open,int close,int n) {
        if(out.length() == 2*n) {
            res.add(out);
            return;
        }
        if(open < n) {
            helper(res,out+"(",open+1,close,n);
        }
        if(close < open) {
            helper(res,out+")",open,close+1,n);
        }
    }
}
