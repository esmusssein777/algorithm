package com.ligz.algorithm.tree;

import com.ligz.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * author:ligz
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> r = new ArrayList<>();
        r.add(root.val);
        lists.add(r);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    list.add(node.left.val);
                    queue.offer(node.left);
                }
                if(node.right != null){
                    list.add(node.right.val);
                    queue.offer(node.right);
                }
            }
            if(!list.isEmpty()) lists.add(list);
        }
        return lists;
    }
}
