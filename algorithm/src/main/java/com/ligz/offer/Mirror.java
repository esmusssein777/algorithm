package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 * author:ligz
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        exch(root, root.left, root.right);
    }

    private void exch(TreeNode root, TreeNode left, TreeNode right) {//镜像就是给一个左子树和右子树，左子树等于右边，右边等于左边
        root.left = right;
        root.right = left;
        if (right != null) exch(root.left, right.left, right.right);
        if (left != null) exch(root.right, left.left, left.right);
    }
}
