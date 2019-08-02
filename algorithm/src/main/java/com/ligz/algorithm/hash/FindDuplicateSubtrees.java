package com.ligz.algorithm.hash;

import com.ligz.datastructure.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值
 *
 * @author: ligz
 */
public class FindDuplicateSubtrees {
    /**
     * 目标：寻找重复的子树
     * 分析：将每一个节点 node 做为 map 的 key,找到一个key可以承载这个节点的val和左右子树的信息
     * 错误：1.错将 node 作为key,导致相同结构的 node 不相等
     * 错误：2.错误的判断了 map 里面的value数量，加入了重复的 node，应该等于 1 的时候加入，小于1或者大于1都不加入
     * 关键：如何将 node 的 val 和子树的信息作为 key
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        find(root, map, res);
        return res;
    }

    public String find(TreeNode root, Map<String,Integer> map, List<TreeNode> res) {
        if (root == null) return "";
        String key = root.val + "," + find(root.left, map, res) + "," + find(root.right, map, res);
        if (map.containsKey(key) && map.get(key) == 1) {
            res.add(root);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
