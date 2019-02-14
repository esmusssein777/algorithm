package com.ligz.algorithm.tree.ntree;

import com.ligz.datastructure.tree.Node;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * author:ligz
 */
public class MaxDepth {
    private int max = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        maxDepth(root, 1);
        return max;
    }

    public void maxDepth(Node node, int depth) {
        if (node == null) return;
        max = Math.max(max, depth);
        for (Node child : node.children){
            maxDepth(child, depth+1);
        }
    }
}
