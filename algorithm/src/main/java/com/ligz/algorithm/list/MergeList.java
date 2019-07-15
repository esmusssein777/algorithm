package com.ligz.algorithm.list;

/**
 * 合并两个有序链表
 * author:ligz
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeList {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode res = head;
		if (l1 == null && l2 == null) return head.next;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		head.next = l1 == null ? l2 : l1;
		return res.next;
	}

/*	第一次错误的写成了递归的形式，最后输出的124，是因为最后的代码写错了，迭代到最后变成了head.next = l1
	ListNode head = new ListNode(0);
	ListNode res = head;
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return res.next;
		if (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ListNode cur = new ListNode(l1.val);
				head.next = cur;
				mergeTwoLists(l1.next, l2);
			} else {
				ListNode cur = new ListNode(l2.val);
				head.next = cur;
				mergeTwoLists(l1, l2.next);
			}
		}
		head.next = l1 == null ? l2 : l1;
		return res.next;
	}*/

}
