package com.ligz.algorithm.tree.bst;

import com.ligz.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author:ligz
 */
public class BSTIterator {
    Queue<Integer> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            queue.add(root.val);
            inorder(root.right);
        }
    }
}
