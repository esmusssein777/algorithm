package com.ligz.offer;

import com.ligz.datastructure.list.RandomListNode;

/**
 * author:ligz
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;

        while (cur != null) {//复制next,就放到后面
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
