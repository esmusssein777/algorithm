package com.ligz.offer;

import com.ligz.datastructure.list.RandomListNode;

/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 * author:ligz
 */
public class Clone {
    /**
     * 先复制每一个节点，再复制他们的随机节点，再拆开来
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;

        while (cur != null) {//复制每一个节点,就放到该节点的后面
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = pHead;
        while (cur != null) {//复制random
            RandomListNode clone = cur.next;
            if (cur.random != null) clone.random = cur.random.next;//复制向random的next，即第一步复制出的节点
            cur = clone.next;
        }

        cur = pHead;
        RandomListNode res = cur.next;
        while (cur.next != null) {//拆分,需要拆分两个，只需要将每个的next都跨越一个节点
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return res;
    }
}
