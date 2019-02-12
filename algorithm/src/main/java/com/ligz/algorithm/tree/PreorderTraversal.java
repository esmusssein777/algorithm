package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历二叉树
 * author:ligz
 */
public class PreorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pre(root);
        return list;
    }

    public void pre(TreeNode root){
        if(root != null){
            list.add(root.val);
            pre(root.left);
            pre(root.right);
        }
    }
}
