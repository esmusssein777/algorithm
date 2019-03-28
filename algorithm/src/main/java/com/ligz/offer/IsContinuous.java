package com.ligz.offer;

/**
 * 扑克牌顺子
 * 巨麻烦，反正简单的就是选出5张牌，是连续的就是true,大小王可以
 * author:ligz
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        int num[] = new int[14];
        if (numbers == null || numbers.length != 5) return false;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;//存放最大最小值，相差大于5则不是连续的
        for (int n : numbers) {
            num[n]++;
            if (n == 0) continue;//如果是大小王则忽略
            if (num[n] > 1) return false;//除去大小王没有重复的牌
            if (max < n) max = n;
            if (min > n) min = n;
        }
        if (max - min >= 5) return false;
        return true;
    }
}
