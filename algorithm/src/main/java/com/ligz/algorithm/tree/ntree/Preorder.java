package com.ligz.algorithm.tree.ntree;

import com.ligz.datastructure.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历
 * author:ligz
 */
public class Preorder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return list;
        list.add(root.val);
        pre(root);
        return list;
    }

    public void pre(Node root){
        if(root.children != null){
            for (Node children : root.children){
                list.add(children.val);
                pre(children);
            }
        }

    }
}
