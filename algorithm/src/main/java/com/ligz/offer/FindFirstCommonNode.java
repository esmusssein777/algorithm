package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 * author:ligz
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode fir = pHead1;
        ListNode sec = pHead2;
        while (fir != sec) {
            fir = fir == null ? pHead2 : fir.next;
            sec = sec == null ? pHead1 : sec.next;
        }
        return fir;
    }
}
