package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 * author:ligz
 */
public class Convert {
    private TreeNode pre;//只需要一个指针记录一下前面的
    private TreeNode head;//这个指针只用一次，就是记录一下头部
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        root.left = pre;//左边指向前面的节点
        if (pre != null) pre.right = root;//如果前面的不为null，那么前面的右指针指向当前
        pre = root;
        if (head == null) head = pre;
        inOrder(root.right);
    }
}
