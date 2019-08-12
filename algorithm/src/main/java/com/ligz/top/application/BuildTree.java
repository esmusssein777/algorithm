package com.ligz.top.application;

import com.ligz.datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * @author: ligz
 */
public class BuildTree {
    /**
     * 目标：如何从中序与后序遍历序列构造二叉树
     * 分析：这一类题需要我们把中序链表放入 map 中，根据后序的顺序来递归出每个节点的左子树和右子树
     * 错误：这题需要先遍历右子树再遍历左子树，不要乱顺序
     * 关键：以中序为基础，以后序链表从后往前的顺序构建出每个节点的左子树和右子树
     */

    Map<Integer, Integer> map = new HashMap<>();//存放中序的映射
    int pindex = 0;//后序的索引

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pindex = postorder.length - 1;//因为二叉树的第一个节点对应后序的最后一个，从最后一个开始
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param postorder 后序链表
     * @param inl 中序的左边界
     * @param inr 中序的右边界
     * @return 二叉树节点
     */
    public TreeNode build(int[] postorder, int inl, int inr) {
        if (inl > inr) return null;
        TreeNode node = new TreeNode(postorder[pindex--]);//从最后一个开始初始化为TreeNode
        int index = map.get(node.val);//得到在中序的索引
        node.right = build(postorder, index + 1, inr);//先遍历右子树
        node.left = build(postorder, inl, index - 1);//再遍历左子树
        return node;
    }
}
