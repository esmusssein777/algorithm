package com.ligz.top.application;

import com.ligz.datastructure.list.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class MergeTwoLists {
    /**
     * 目标：如何遍历两个链表，是迭代还是递归来遍历两个链表
     * 分析：遍历两个链表，比较大小，小的放入head.next,
     * 错误：使用了递归，递归的终止条件没有设定好，递归到最后执行head.next = l1 == null ? l2 : l1;结果显然就等于l1
     * 关键：理清终止条件，将两个链表不同状态下(是否为null)对应的情况理清楚，其他的就属于对list数据结构的考查
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        if (l1 == null && l2 == null) return head.next;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
