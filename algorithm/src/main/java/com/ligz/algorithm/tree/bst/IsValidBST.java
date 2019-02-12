package com.ligz.algorithm.tree.bst;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * author:ligz
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
