package com.ligz.algorithm.list;

/**
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点
 * author:ligz
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {
    //链表节点
    static class ListNode {
        int val;
        CycleList2.ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void deleteNode(ListNode node) {//这题跟个鬼一样....将本身复制成下一个节点，然后删掉下一个节点，就把本身删除了
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
