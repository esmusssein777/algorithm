package com.ligz.algorithm.list;

/**
 * 移除链表元素
 * author:ligz
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val){
			head = head.next;
		}
		if(head == null || head.next == null){
			return head;
		}
		ListNode preNode = head;//等于当前遍历节点的前一个节点
		ListNode curNode = preNode.next;//等于当前遍历节点的节点
		while (curNode != null){
			if(curNode.val == val){
				preNode.next = curNode.next;
				curNode = curNode.next;
			}else {
				preNode = preNode.next;
				curNode = curNode.next;
			}
		}
		return head;
	}
}
