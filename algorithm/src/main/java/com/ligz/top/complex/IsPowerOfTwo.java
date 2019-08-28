package com.ligz.top.complex;

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 */
public class IsPowerOfTwo {
    /**
     * 目标：是否是 2 的幂次方
     * 分析：判断 %2 是否不为0
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}
