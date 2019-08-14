package com.ligz.top.application;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * @author: ligz
 */
public class FindPath {
    /**
     * 目标：二叉树中结点值的和为输入整数的所有路径
     * 分析：如何遍历二叉树的问题，从上到下 target 值一直减少这种思路好写。
     * 错误：lists.add(new ArrayList(list)) 写成 lists.add(list)。这样得到的是空的 list，因为后面的 list.remove()又把值去掉了，必须创建一个新的对象放进去
     * 关键：target 递减的写法；lists放入新的list对象。
     */
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return lists;
        search(root, target, new ArrayList());
        return lists;
    }

    public void search(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            lists.add(new ArrayList(list));
        } else {
            search(root.left, target, list);
            search(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}
