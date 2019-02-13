package com.ligz.datastructure.tree;

import java.util.List;

/**
 * N-ary Tree
 * author:ligz
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node(){};

    public Node(int _val, List<Node> _children){
        val = _val;
        children = _children;
    }
}
