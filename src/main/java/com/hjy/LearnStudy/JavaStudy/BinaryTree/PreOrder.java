package com.hjy.LearnStudy.JavaStudy.BinaryTree;

import com.didi.mybatis.demo.JavaStudy.TreeNode;

import java.util.Stack;

/**
 * @author huangjunyan
 * @date 2019-07-25 15:41
 */
public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preOrderNoRecursive(root);
    }
    public static void preOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    public static void preOrderNoRecursive(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while(!stack.isEmpty()) {
            while(node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
