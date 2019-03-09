package com.ligz.algorithm.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * author:ligz
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {//其实大顶堆也是排序，感觉偷鸡了....应该是nlogn
        //不用大顶堆，用 hashSet,判断
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>();//小顶堆
        for (int n : nums) {
            queue.add(n);
        }
        int max = 1;
        int res = 1;
        while (!queue.isEmpty()) {//每一次将数据拿出来对比减一，取最大
            int first = queue.poll();
            if (queue.isEmpty()) break;
            int sec = queue.peek();
            if (sec - first == 1){
                res++;
                max = Math.max(res, max);
            }else if(sec - first == 0) {
                continue;
            }else {
                res = 1;
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 1;
        for (int n : nums) {
            int res = 1;
            if (!set.contains(n - 1)) {
                int plus = n + 1;
                while (set.contains(plus)) {
                    plus++;
                    res++;
                }
                max = Math.max(res, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LongestConsecutive l = new LongestConsecutive();
        int[] num = {100,4,200,1,3,2};
        l.longestConsecutive(num);
    }
}
