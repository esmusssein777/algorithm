package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 链表中倒数第k个结点
 * author:ligz
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        //先让 p1 走 k 步，再让 p1 和 p2 一起走 n - k 步，p2 剩下来的路就是 n - (n - k) = k，此时返回 p2
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;//如果超过，那么返回null
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
