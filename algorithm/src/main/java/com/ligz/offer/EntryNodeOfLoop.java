package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 * author:ligz
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return null;
        }
        ListNode cur = pHead;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
