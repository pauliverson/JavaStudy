package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-26 17:05
 */
public class Leet39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public static void helper(List<List<Integer>> res,List<Integer> out,int[] candidates,int target,int i) {
        if(target < 0)
            return;
        if(target == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        for(int j = i;j < candidates.length;j++) {
            out.add(candidates[j]);
            helper(res,out,candidates,target - candidates[j],j);
            out.remove(out.size()-1);
        }
    }
}
