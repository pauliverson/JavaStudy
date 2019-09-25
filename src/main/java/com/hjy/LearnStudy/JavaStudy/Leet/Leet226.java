package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangjunyan
 * @date 2019-07-25 10:54
 */

public class Leet226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);

        }
        return root;
    }
    public void invertTree1(TreeNode root) {
        if(root == null)
            return;

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree1(root.left);
        invertTree1(root.right);
    }
}
