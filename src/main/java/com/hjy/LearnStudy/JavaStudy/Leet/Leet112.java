package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Stack;

/**
 * @author huangjunyan
 * @date 2019-07-26 17:22
 */
public class Leet112 {

    public static boolean hasPathSum(TreeNode root,int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
    public static boolean hasPathSum1(TreeNode root,int sum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) {
                if(node.val == sum)
                    return true;
            }
            if(node.left != null) {
                node.left.val += node.val;
                stack.push(node.left);
            }
            if(node.right != null) {
                node.right.val += node.val;
                stack.push(node.right);
            }
        }
        return false;
    }
}
