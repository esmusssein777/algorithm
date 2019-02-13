package com.ligz.algorithm.tree.ntree;

import com.ligz.datastructure.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * author:ligz
 */
public class Postorder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return list;
        post(root);
        list.add(root.val);
        return list;
    }

    public void post(Node root){
        if(root.children != null){
            for (Node children : root.children){
                post(children);
                list.add(children.val);
            }
        }

    }
}
