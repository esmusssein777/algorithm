package com.ligz.algorithm.list;

/**
 * 奇偶链表
 * author:ligz
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class EvenOdd {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode even = head;//奇数
		ListNode odd = head.next;//偶数
		ListNode secNode = head.next;//需要一个数记录第二个数
		while (even.next != null && odd.next != null){
			even.next = even.next.next;
			odd.next = odd.next.next;
			even = even.next;
			odd = odd.next;
		}
		even.next = secNode;
		return head;
	}
}
