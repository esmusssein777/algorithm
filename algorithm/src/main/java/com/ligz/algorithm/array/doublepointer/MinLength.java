package com.ligz.algorithm.array.doublepointer;

/**
 * 长度最小的子数组
 * author:ligz
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinLength {
	public int minSubArrayLen(int s, int[] nums) {
		int min = 0, minHere = 0;
		for(int i = 0; i < nums.length; i++){
			int minSum = 0;
			for(int j = i; j < nums.length; j++){
				minSum += nums[j];
				if(minSum >= s){
					minHere = j - i + 1;
					break;
				}
			}
			if(min == 0){
				min = minHere;
			}else{
				min = Math.min(min, minHere);
			}
		}
		return min;
	}

	/**
	 * 目标：怎么样才能找出最小长度的连续子数组
	 * 分析：双指针，判断和大于 s 的时候，左边指针右移，否则右指针右移。记录最小的情况
	 * 错误：最后没有判断 res 是不是 MAX 值，当数组为空的时候输出应该输出 0
	 * 关键：最关键的是字是 连续 ，这是我们使用双指针的前提
	 * Time=O(n),Space=O(1)
	 */
	public int minSubArrayLen2(int s, int[] nums) {//双指针
		int left = 0, sum = 0;
		int res = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= s) {
				res = Math.min(res, right - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		MinLength m = new MinLength();
		m.minSubArrayLen(7,nums);
	}
}
