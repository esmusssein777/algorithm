package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * author:ligz
 */
public class kthSmallest {
    private int sum;
    private int res;
    public int kthSmallest(TreeNode root, int k) {//其实就是一个中序遍历
        sum = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left);
        sum--;
        if(sum == 0) {
            res = root.val;
            return;
        }
        if (root.right != null) inorder(root.right);
    }
}
