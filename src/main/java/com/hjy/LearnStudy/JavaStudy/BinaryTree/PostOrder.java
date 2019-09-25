package com.hjy.LearnStudy.JavaStudy.BinaryTree;

import com.didi.mybatis.demo.JavaStudy.TreeNode;

import java.util.Stack;

/**
 * @author huangjunyan
 * @date 2019-07-25 16:18
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        postOrderNoRecursive(root);
    }
    public static void postOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.val);
    }
    public static void postOrderNoRecursive(TreeNode root) {
        if(root == null)
            return;
        TreeNode cur;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            cur = stack.peek();
            if((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val);
                stack.pop();
                pre = cur;
            }
            else {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }
}
