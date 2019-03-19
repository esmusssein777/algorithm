package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * author:ligz
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = list1;
        ListNode head = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list2 != null) {
            res.next = list2;
        }
        if (list1 != null) {
            res.next = list1;
        }
        return head.next;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return head.next;
    }
}
