package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * author:ligz
 */
public class IsBalanced {
    private boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        balance(root);
        return flag;
    }

    private int balance(TreeNode root) {//判断左右两边的高度差是否大于 1 ，向下递归时高度加 1
        if (root == null || !flag) return 0;
        int left = balance(root.left);
        int right = balance(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return 1 + Math.max(left, right);
    }
}
