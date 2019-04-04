package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

import java.util.*;

/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 * author:ligz
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        boolean flag = true;//当为true时，从左到右遍历
        while (!stack.isEmpty()) {
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> temp = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                if (flag) {
                    if (cur.right != null) temp.push(cur.right);
                    if (cur.left != null) temp.push(cur.left);
                } else {
                    if (cur.left != null) temp.push(cur.left);
                    if (cur.right != null) temp.push(cur.right);
                }
            }
            for (TreeNode node : temp) {
                stack.push(node);
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean flag = false;//当为true时，翻转链表
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (flag) {//利用链表，最后翻转
                Collections.reverse(list);
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}
