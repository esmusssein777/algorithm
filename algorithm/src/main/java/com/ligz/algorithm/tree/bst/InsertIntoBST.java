package com.ligz.algorithm.tree.bst;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 插入二叉搜索树
 * author:ligz
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val){
        if(root != null){
            if(root.val > val){
                if(root.left != null){
                    insert(root.left, val);
                }else {
                    TreeNode node = new TreeNode(val);
                    root.left = node;
                    return;
                }

            }
            if(root.val < val){
                if(root.right != null){
                    insert(root.right, val);
                }else {
                    TreeNode node = new TreeNode(val);
                    root.right = node;
                    return;
                }
            }
        }
    }
}
