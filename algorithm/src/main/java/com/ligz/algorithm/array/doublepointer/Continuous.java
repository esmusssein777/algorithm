package com.ligz.algorithm.array.doublepointer;

/**
 * 连续的1
 * author:ligz
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数
 */
public class Continuous {
	/**
	 * 目标：计算其中最大连续1的个数
	 * 分析：如果为0就重新计数，不为0就+1
	 * 关键：不为1重新计数
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxHere = 0, max = 0;
		for (int n : nums)
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		return max;
	}
}
