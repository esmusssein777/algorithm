package com.ligz.algorithm.list;

import com.ligz.datastructure.list.ListNode;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * @author: ligz
 */
public class RotateRight {
    /**
     * 目标：如何旋转链表
     * 分析：在写过旋转数组后我们会发现，需要先将 k 对长度取余数， 再找到关键的三个点，把他们拆开
     * 错误：没有先连成环就想着拆开，忽略了只有一个节点的情况，返回了 null
     * 关键：找到拆开的左右两个点，先连成环，再把 res = 右边的点
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        k = k % len;
        ListNode res = head;
        for (int i = 0; i < len - k - 1; i++) {
            head = head.next;
        }
        node.next = res;//需要先连成环再拆开，这样不需要考虑只有一个节点的情况
        res = head.next;
        head.next = null;
        return res;
    }
}
