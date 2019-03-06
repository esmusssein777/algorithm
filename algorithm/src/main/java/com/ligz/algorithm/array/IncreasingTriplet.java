package com.ligz.algorithm.array;

/**
 * 递增的三元子序列
 * author:ligz
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)
 * 输入: [1,2,3,4,5]
 * 输出: true
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int n : nums) {//放三个数，如果有大于前面两个的就返回true
            if (n <= small) small = n;
            else if (n <= mid) mid = n;
            else return true;
        }
        return false;
    }
}
