package com.ligz.algorithm.tree.ntree;

import com.ligz.datastructure.tree.Node;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)
 * author:ligz
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> one = new ArrayList<>();
        one.add(root.val);
        lists.add(one);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                if(node.children != null){
                    for (Node children : node.children){
                        list.add(children.val);
                        queue.offer(children);
                    }
                }
            }
            if(!list.isEmpty()) lists.add(list);
        }
        return lists;
    }
}
