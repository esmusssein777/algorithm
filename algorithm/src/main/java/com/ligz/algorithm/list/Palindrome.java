package com.ligz.algorithm.list;

/**
 * 回文链表
 * author:ligz
 *
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2->2->1
 * 输出: true
 *  O(n) 时间复杂度和 O(1) 空间复杂度
 */
public class Palindrome {
	//链表节点
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean isPalindrome(ListNode head) {//改进，用快慢指针得到一半翻转比较
		if (head == null || head.next == null) return true;
		int len = 1;
		ListNode temp = head;
		while (temp.next != null) {//计算长度
			temp = temp.next;
			len++;
		}
		int half = len / 2;
		temp = head;
		ListNode preNode = head;
		while (half != 0) {//得到一半，翻转，比较是否相同
			preNode = temp;
			temp = temp.next;
			half--;
		}
		if (len % 2 != 0){//如果不是偶数，需要在next
			temp = temp.next;
		}
		preNode.next = null;
		temp = reverseList(temp);

		while (head != null){
			if(head.val != temp.val){
				return false;
			}
			head = head.next;
			temp = temp.next;
		}

		return true;
	}
	private ListNode reverseList(ListNode head) {
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

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		ListNode listNode = new ListNode(0);
		listNode.next = new ListNode(0);
		p.isPalindrome(listNode);

	}
}
