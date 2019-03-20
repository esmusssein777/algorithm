package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * author:ligz
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        search(root, target, new ArrayList<>());
        return lists;
    }

    private void search(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            lists.add(new ArrayList<>(list));
        }else {
            search(root.left, target, list);
            search(root.right, target, list);
        }

        list.remove(list.size() - 1);
    }
}
