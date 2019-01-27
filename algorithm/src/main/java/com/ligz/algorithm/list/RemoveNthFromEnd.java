package com.ligz.algorithm.list;

/**
 * author:ligz
 */
public class RemoveNthFromEnd {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		if(head.next == null){
			head = null;
			return null;
		}
		ListNode curNode = head;
		while (curNode != null){
			ListNode tempNode = curNode;
			for(int i =0; i <= n; i++){//需要找到删除点的前面一个点
				if(tempNode != null){//判断是否是头结点
					tempNode = tempNode.next;
				}else {//头结点则删除头结点
					head = head.next;
					return head;
				}

			}
			if(tempNode == null){
				curNode.next = curNode.next.next;//删除节点
				return head;
			}
			curNode = curNode.next;
		}
		return null;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int length  = 0;
		ListNode first = head;
		while (first != null) {//先算出节点的长度
			length++;
			first = first.next;
		}
		length -= n;//将 节点长度 -n = 需要删除的点
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}
}
