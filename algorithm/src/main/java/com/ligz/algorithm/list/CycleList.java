package com.ligz.algorithm.list;

/**
 * 环形链表
 * author:ligz
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class CycleList {
	//链表节点
	static class ListNode {
		int val;
        ListNode next;
        ListNode(int x) {
	        val = x;
            next = null;
        }
    }
	public boolean hasCycle(ListNode head) {
		ListNode slowNode = head;
		ListNode quickNode = head;
		while(slowNode != null && quickNode != null && quickNode.next != null){//慢的走一步，快的走两步，直到null不相等才为false
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
			if(slowNode == quickNode){
				return true;
			}
		}
		return false;
	}
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */