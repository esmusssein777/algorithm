package com.ligz.algorithm.tree.bst;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 删除二叉搜索树中的某一个
 * author:ligz
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root != null){
            if(root.val > key) root.left = deleteNode(root.left, key);
            if(root.val < key) root.right = deleteNode(root.right, key);
            if(root.val == key){
                if(root.left == null){
                    return root.right;
                }else if(root.right == null){
                    return root.right;
                }else {
                    TreeNode left = finLeft(root.right);
                    root.val = left.val;
                    root.right = deleteNode(root.right, root.val);
                }
            }
        }
        return root;
    }

    public TreeNode finLeft(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}
