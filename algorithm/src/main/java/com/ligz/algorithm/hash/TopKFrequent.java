package com.ligz.algorithm.hash;

import java.util.*;

/**
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * author:ligz
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int n : map.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
