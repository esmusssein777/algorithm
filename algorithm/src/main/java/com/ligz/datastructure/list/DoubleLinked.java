package com.ligz.datastructure.list;

/**
 * 双链表
 * author:ligz
 */
public class DoubleLinked {

	static class Node {//使用内部类，对应当前值和引用下一个的node
		int val;
		Node next,prev;
		Node(int x) { val = x; }
	}

	private int len;

	private Node head;
	/** Initialize your data structure here. */
	public DoubleLinked() {

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		Node node = findByIndex(index);
		return node == null ? -1 : node.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addAtIndex(len, val);
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if(index < 0 || index > len){
			return;
		}
		Node preNode = findByIndex(index - 1);
		Node node = new Node(val);
		if(preNode == null){
			head = node;
		}else if(index == 0){
			head.prev = node;
			node.next = head;
			head = node;
		}else {
			node.prev = preNode;
			node.next = preNode.next;
			preNode.next.prev = node;
			preNode.next = node;
		}
		len++;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(index < 0 || index > len - 1 || len == 0){
			return;
		}
		Node node = findByIndex(index);
		if(index == 0){
			head = head.next;
		}else {
			if(node != null){
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
		}
		len--;
	}

	private Node findByIndex(int index){
		if(index <= 0) {
			return head;
		}
		if(len == 0 || index >= len){
			return null;
		}
		Node cur = head.next;
		for(int i = 1; i < index; i++){
			cur = cur.next;
		}
		return cur;
	}
}
