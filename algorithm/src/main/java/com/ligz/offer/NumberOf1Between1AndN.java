package com.ligz.offer;

/**
 * 计算 1 到 n 的所有1出现的次数
 * author:ligz
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            res += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return res;
    }
}
