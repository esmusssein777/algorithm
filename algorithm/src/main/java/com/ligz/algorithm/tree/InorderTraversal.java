package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
 * author:ligz
 */
public class InorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
