package com.ligz.algorithm.dp;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * author:ligz
 */
public class IntegerBreak {
    int[] num;
    public int integerBreak(int n) {
        num = new int[n + 1];//使用记忆化搜索
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) return 1;
        if (num[n] != 0) return num[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max(res, i * (n - i), i * dfs(n - i));
        }
        num[n] = res;//将 n 的分割情况记录下来
        return res;
    }


    private int max(int a, int b, int c) {
        int temp = Math.max(b, c);
        return Math.max(a, temp);
    }


    //严格的动态规划，从底向上，比较难想出来
    private int breakInteger(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i < n; i ++) {
            for (int j = 1; j < i; j++) {
                nums[i] = max(nums[i],j * (i - j), j * nums[i - j]);
            }
        }
        return nums[n];
    }

}
