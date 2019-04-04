package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * author:ligz
 */
public class SerializeTree {
    String serializeStr;

    String Serialize(TreeNode root) {//前序遍历二叉树，用 # 代替null
        if (root == null) return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        serializeStr = str;
        return deserialize();
    }

    TreeNode deserialize() {//将字符串分解，按反向前序的方法构建二叉树
        if (serializeStr.length() == 0) return null;
        int index = serializeStr.indexOf(" ");
        String node = index == -1 ? serializeStr : serializeStr.substring(0, index);
        serializeStr = index == -1 ? "" : serializeStr.substring(index + 1);
        if ("#".equals(node)) return null;
        TreeNode head = new TreeNode(Integer.valueOf(node));
        head.left = deserialize();
        head.right = deserialize();
        return head;
    }

}
