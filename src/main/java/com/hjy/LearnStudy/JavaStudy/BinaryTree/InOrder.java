package com.hjy.LearnStudy.JavaStudy.BinaryTree;

import com.didi.mybatis.demo.JavaStudy.TreeNode;

import java.util.Stack;

/**
 * @author huangjunyan
 * @date 2019-07-25 15:59
 */
public class InOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        InOrderNoRecursive(root);
//        InOrder inOrder1 = new InOrder();
//        InOrder inOrder2 = new InOrder();
    }
//    static {
//        System.out.println("静态代码块");
//    }
//    {
//        System.out.println("普通代码块");
//    }
//    public InOrder() {
//        System.out.println("构造器");
//    }
    public static void InOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        InOrderRecursive(root.left);
        System.out.println(root.val);
        InOrderRecursive(root.right);
    }
    public static void InOrderNoRecursive(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }


}
