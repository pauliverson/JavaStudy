package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-26 17:48
 */
public class Leet113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),root,sum);
        return res;
    }
    public static void helper(List<List<Integer>> res,List<Integer> out,TreeNode root,int sum) {
        if(root == null) {
            return;
        }
        out.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) {
            res.add(out);
        }
        helper(res,out,root.left,sum - root.val);
        helper(res,out,root.right,sum-root.val);
        out.remove(out.size()-1);
    }
}
