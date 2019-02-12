package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历二叉树
 * author:ligz
 */
public class PostorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }

    public void postorder(TreeNode root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            list.add(root.val);
        }
    }
}
