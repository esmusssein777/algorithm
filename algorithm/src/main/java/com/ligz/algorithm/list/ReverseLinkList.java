package com.ligz.algorithm.list;

/**
 * 反转链表
 * author:ligz
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkList {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode headNode = head;//头部节点
		ListNode curNode = head;//当前遍历的节点
		while (curNode != null && curNode.next != null){
			ListNode temp = curNode.next.next;
			head = curNode.next;
			head.next = headNode;
			curNode.next = temp;
			headNode = head;
		}
		return head;
	}


}
