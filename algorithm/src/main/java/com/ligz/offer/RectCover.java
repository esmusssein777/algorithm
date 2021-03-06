package com.ligz.offer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * ![](https://uploadfiles.nowcoder.com/images/20170718/3614591_1500381257269_B18DB55610F4CC5E67C96674FE51EBDC)
 * author:ligz
 */
public class RectCover {
    public int RectCover(int target) {//还是斐波那契数列，
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
