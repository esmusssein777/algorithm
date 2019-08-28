package com.ligz.top.complex;

import com.ligz.datastructure.list.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    /**
     * 目标：合并K个排序链表
     * 分析：注意不是合并两个，而是 k 个，可以两两合并，也可以用空间换时间，用最小堆来实现
     * 错误：使用比较每个链表的最小值来构建，很慢 O(n*m)，使用最小堆 O(n * log(m))排序log(m)
     * 关键：注意不是合并两个，而是 k 个
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return head.next;
    }
}
