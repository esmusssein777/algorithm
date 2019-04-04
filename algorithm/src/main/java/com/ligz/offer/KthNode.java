package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 二叉搜索树的第k个结点给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
 *
 * author:ligz
 */
public class KthNode {
    int sum = 0;
    TreeNode res;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return res;
    }

    private void inOrder(TreeNode root, int k) {//step+1 用来计算深度，这个并不是往下走了几次，而是中序遍历开始计算
        if (root != null) {
            inOrder(root.left, k);
            sum++;
            if (sum == k) res = root;
            inOrder(root.right, k);
        }
        return;
    }
}
