package com.ligz.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形链表 II
 * author:ligz
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class CycleList2 {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode hasCycle2(ListNode head) {
		ListNode slowNode = head;
		ListNode quickNode = head;
		int len = 0;//环长度
		while(slowNode != null && quickNode != null && quickNode.next != null){//慢的走一步，快的走两步，直到null不相等才为false
			len++;
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
			if(slowNode == quickNode){
				while (head!= null){//确定有环，那么从head开始遍历。环内的节点是否有相同的，相同则是最开始的节点
					for(int i =0; i < len; i++){
						if(slowNode == head){
							return slowNode;
						}
						slowNode = slowNode.next;
					}
					head = head.next;
				}

			}
		}
		return null;
	}

	public ListNode hasCycle(ListNode head) {//https://blog.csdn.net/qq_39071530/article/details/86494173
		ListNode slowNode = head;
		ListNode quickNode = head;
		boolean flag = false;
		while(slowNode != null && quickNode != null && quickNode.next != null){//慢的走一步，快的走两步，直到null不相等才为false
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
			if(slowNode == quickNode){
				flag = true;
				break;
			}
		}
		if(!flag){
			return null;
		}
		slowNode = head;
		while (slowNode != quickNode){//一个从起点开始，一个从指针交点开始。当他们相等时即使交点
			slowNode = slowNode.next;
			quickNode = quickNode.next;
		}
		return slowNode;
	}
}
