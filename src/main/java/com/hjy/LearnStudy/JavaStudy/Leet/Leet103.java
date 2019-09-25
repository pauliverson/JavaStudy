package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.*;

/**
 * @author huangjunyan
 * @date 2019-07-19 17:16
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }
}
public class Leet103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag = 0;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> out = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                if(flag % 2 == 0) {
                    out.add(node.val);
                } else {
                    out.add(0,node.val);
                }
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(out);
            flag++;
        }
        return res;
    }
}
