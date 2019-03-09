package com.ligz.algorithm.hash;

import java.util.HashSet;

/**
 * 只出现一次的数字
 * author:ligz
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleOne {
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			if(set.contains(nums[i])){
				set.remove(nums[i]);
			}else {
				set.add(nums[i]);
			}

		}
		return set.iterator().next();
	}
	public int singleNumber2(int[] nums) {
		int res = 0;
		for (int num : nums) {//遇一个数两次不会变
			res = res ^ num;
		}
		return res;
	}

	public static void main(String[] args) {
		SingleOne singleOne = new SingleOne();
		int[] nums = {4,1,2,1,2};
		singleOne.singleNumber2(nums);
	}

}
