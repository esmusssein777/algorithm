package com.ligz.algorithm.list;

/**
 * 相交链表
 * author:ligz
 */
public class IntersectList {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode head = headB;
		if(headA == null || headB == null){
			return null;
		}
		if(headA == headB){
			return headA;
		}
		while (headA != null){
			headB = head;
			while (headB!= null){
				if(headA.next == headB.next){
					return headB.next;
				}
				if(headA.next == headB){
					return headB;
				}
				if(headB.next == headA){
					return headA;
				}
				headB = headB.next;
			}
			headA = headA.next;
		}
		return null;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {//为什么别人能写的这么简单。。复杂度都是O(m*n)
		//boundary check
		if(headA == null || headB == null) return null;

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while( a != b){
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = a == null? headB : a.next;
			b = b == null? headA : b.next;
		}

		return a;
	}
}
