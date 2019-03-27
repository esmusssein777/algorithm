package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * author:ligz
 */
public class TreeDepth {
    int res = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        depth(root, 1);
        return res - 1;
    }

    private void depth(TreeNode root, int step) {
        if (root != null) {
            depth(root.left, step + 1);
            depth(root.right, step + 1);
        } else {
            res = Math.max(res, step);
        }
    }

    public int TreeDepth2(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth2(root.left), TreeDepth2(root.right));
    }

}
