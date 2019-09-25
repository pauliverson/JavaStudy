package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-26 18:00
 */
public class Leet40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        for(int i = 0;i < visited.length;i++) {
            visited[i] = false;
        }
        helper(res,new ArrayList<>(),candidates,target,0,visited);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> out,int[] candidates,int target,int start,boolean[] visited) {
        if(target < 0)
            return;
        if(target == 0) {
            if(!res.contains(out)) {
                res.add(new ArrayList<>(out));
            }
            return;
        }
        for(int i = start;i < candidates.length;i++) {
            if(!visited[i]) {
                out.add(candidates[i]);
                visited[i] = true;
                helper(res,out,candidates,target-candidates[i],i+1,visited);
                out.remove(out.size()-1);
                visited[i] = false;
            }
        }
    }
}
