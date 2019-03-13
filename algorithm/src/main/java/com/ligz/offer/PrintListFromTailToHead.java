package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 * author:ligz
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
