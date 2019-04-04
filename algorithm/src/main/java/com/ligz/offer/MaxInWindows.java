package com.ligz.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 * author:ligz
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0 || size > num.length) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> (n2 - n1));//大顶堆
        for (int i = 0; i < size; i++) {
            queue.offer(num[i]);
        }
        for (int i = 0; i < num.length - size; i++) {//一遍取一遍放出去
            list.add(queue.peek());
            queue.remove(num[i]);
            queue.offer(num[i + size]);
        }
        list.add(queue.peek());
        return list;
    }
}
