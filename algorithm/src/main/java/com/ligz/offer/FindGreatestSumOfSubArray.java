package com.ligz.offer;

/**
 * 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 * author:ligz
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int num : array) {
            res = res < 0 ? num : res + num;//还是比较神奇的，如果前面的和为负数，那么就只管后面的和，不管前面的
            max = Math.max(max, res);
        }
        return max;
    }
}
