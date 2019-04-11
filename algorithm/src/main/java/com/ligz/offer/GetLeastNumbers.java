package com.ligz.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 * author:ligz
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length < k || k < 0) return new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : input) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}
