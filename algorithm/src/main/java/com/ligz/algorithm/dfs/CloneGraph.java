package com.ligz.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ligz
 */
public class CloneGraph {
    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return node;
    }
}
