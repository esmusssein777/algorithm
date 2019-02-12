package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 对称二叉树
 * author:ligz
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode left, TreeNode right){//变为两个相同的tree，一个遍历左边，一个遍历右边
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
