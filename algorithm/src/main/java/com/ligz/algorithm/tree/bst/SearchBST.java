package com.ligz.algorithm.tree.bst;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 在二叉搜索树中实现搜索操作
 * author:ligz
 * 如果目标值等于节点的值，则返回节点;
 * 如果目标值小于节点的值，则继续在左子树中搜索;
 * 如果目标值大于节点的值，则继续在右子树中搜索
 */
public class SearchBST {
    TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        search(root, val);
        return node;
    }

    public void search(TreeNode root, int val){
        if(root != null){
            if(root.val == val) node = root;
            if(root.val > val) searchBST(root.left, val);
            searchBST(root.right, val);
        }
    }
}
