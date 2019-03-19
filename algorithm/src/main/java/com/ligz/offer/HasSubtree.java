package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * author:ligz
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);//只要这里面有任何一个成立即为有子节点
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;// 2遍历完了的话就是true
        if (root1 == null) return false;// 1遍历完2还没遍历完即为false
        if (root1.val != root2.val) return false;// 如果有任何一个节点不相等也是false
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
