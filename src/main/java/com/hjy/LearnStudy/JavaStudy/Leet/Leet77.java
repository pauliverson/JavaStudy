package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-26 15:03
 */
public class Leet77 {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(5,3);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n,k,1,res,new ArrayList<>());
        return res;
    }
    public static void helper(int n,int k,int level,List<List<Integer>> res,List<Integer> out) {
        if(out.size() == k) {
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i = level;i <= n;i++) {
            out.add(i);
            helper(n,k,i+1,res,out);
            out.remove(out.size()-1);
        }
    }

}
