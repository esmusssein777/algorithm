package com.ligz.offer;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * author:ligz
 */
public class JumpFloor {
    public int JumpFloor(int target) {//其实就是斐波那契，不同的是num[0] = 1
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < target + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
