package com.ligz.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
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
