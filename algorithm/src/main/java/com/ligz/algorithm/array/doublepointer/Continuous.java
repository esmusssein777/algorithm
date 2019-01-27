package com.ligz.algorithm.array.doublepointer;

/**
 * 连续的1
 * author:ligz
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数
 */
public class Continuous {
	public int findMaxConsecutiveOnes(int[] nums) {
		int m = 0;
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 1){//从某个1开始计数
				for(int j = i + 1; j < nums.length; j++){
					if(nums[j] == 1){//记录到最后一个1的位置
						m = j;
					}else {
						break;
					}
				}
				if(max < m - i + 1){//计数最后一个1到第一个1的长度
					max = m - i + 1;
				}
				if(max == 0){//如果只有一个1，那么就为1
					max++;
				}
			}
			
		}
		return max;
	}

	public int findMaxConsecutiveOnes2(int[] nums) {
		int maxHere = 0, max = 0;
		for (int n : nums)
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		return max;
	}
}
