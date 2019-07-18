package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * author:ligz
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {//把下一个节点放到头部去就行
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    /**
     * 递归法，比较麻烦
     * 详解：https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1209/
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
