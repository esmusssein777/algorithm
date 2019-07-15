package com.ligz.algorithm.recursion;

import com.ligz.datastructure.list.ListNode;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    /**
     * 最经典的递归题目了
     * 目标：如何拆分成子问题递归
     * 分析：交换前面两个节点，再swapPairs(next.next)交换后面的节点，最后确定head
     * 错误：下面的错误解法，正确但是没必要。是先换好再链接后面。应该先链接后面再换head
     * 关键：理清终止条件
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 自己的解法，很麻烦
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode three = head.next.next;
        head = head.next;
        head.next = temp;
        head.next.next = swapPairs(three);
        return head;
    }
}
