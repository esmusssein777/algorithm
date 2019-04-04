package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 * author:ligz
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSame(pRoot.left, pRoot.right);
    }
    boolean isSame(TreeNode left, TreeNode right) {//递归交叉查询左右是否相等
        if (left == null && right == null) return true;
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val == right.val) return isSame(left.left, right.right) && isSame(left.right, right.left);
        else return false;
    }
}
