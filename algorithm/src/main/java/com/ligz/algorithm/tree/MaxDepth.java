package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 二叉树的最大深度
 * author:ligz
 */
public class MaxDepth {
    int step = 1;
    int result = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        depth(root, step);
        return result - 1;
    }

    public void depth(TreeNode root, int step){
        if(root != null){
            depth(root.left, step + 1);
            depth(root.right, step + 1);
        }else {
            result = Math.max(step, result);
        }
    }
}
