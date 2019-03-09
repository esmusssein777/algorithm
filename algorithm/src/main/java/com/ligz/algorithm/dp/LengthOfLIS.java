package com.ligz.algorithm.dp;

/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * author:ligz
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 0) return 0;
        int[] memo = new int[len];
        for (int i = 0; i < len; i++) {
            memo[i] = 1;
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {//一直叠加，对应上面的数组答案是 10,9,2,5,3,7,101,18 数组对应 1,1,1,2,2,3,4,4
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        for (int n : memo) {
            res = Math.max(res, n);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        l.lengthOfLIS(nums);
    }
}
