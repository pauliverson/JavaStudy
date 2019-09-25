package com.hjy.LearnStudy.JavaStudy.ALiBaBa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pauljy
 * @program test
 * @description 打印出每一层最右边的节点
 * @date 2019-09-18 14:41
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}

public class PrintRightNode {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(printLevelRight(root));
    }

    public static List<Integer> printLevelRight(TreeNode root) {
        //存储每层右边的值的列表
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //层次遍历使用的辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int value = 0;
            while (size != 0) {
                TreeNode node = queue.poll();
                size--;
                value = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(value);

        }
        return result;
    }
}
