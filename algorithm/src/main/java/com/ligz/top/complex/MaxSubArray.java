package com.ligz.top.complex;

/**
 * 最大子序和
 * @author: ligz
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int count = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max ;
    }
}
