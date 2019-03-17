package com.ligz.offer;

import java.util.Arrays;

/**
 * author:ligz
 */
public class Fibonacci {
    int[] nums;
    int res = 0;
    public int Fibonacci(int n) {
        nums = new int[n + 1];
        Arrays.fill(nums, - 1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (nums[n] != -1) return nums[n];
        nums[n] = dfs(n - 1) + dfs(n - 2);
        return nums[n];
    }

    public int Fibonacci2(int n) {
        if (n == 0) return 0;
        int[] num = new int[n + 1];
        int res = 0;
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.Fibonacci2(0));

    }
}
