package com.ligz.algorithm.array;

/**
 * 乘积最大子序列
 * author:ligz
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的 连续 子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                res = res * nums[j];
                max = Math.max(max, res);
            }
        }
        for (int i : nums) {//遍历完后，还要和数组里面的数对比看看是否是最大的
            max = Math.max(max, i);
        }
        return max;
    }

    public int maxProduct2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {//保存最大值和最小值，遇到负数他们会交换位置
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
