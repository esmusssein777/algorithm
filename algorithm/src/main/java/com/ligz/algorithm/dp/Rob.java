package com.ligz.algorithm.dp;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * author:ligz
 */
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] memo = new int[len];
        memo[0] = nums[0];
        int res= 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {//需要判断当前的偷不偷，不偷就是前面的最大值，偷就加上当前的金钱，并与 - 2 的值相加
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 < 0 ? 0 : memo[j - 2]));
            }
        }
        return memo[len - 1];
    }
}
