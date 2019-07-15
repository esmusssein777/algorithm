package com.ligz.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * author:ligz
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
	public int[] twoSum4(int[] numbers, int target) {
		int m = 0, n = numbers.length - 1;
		while (m < n) {
			int count = numbers[m] + numbers[n];
			if (count < target) {
				m++;
			} else if (count > target) {
				n--;
			} else {
				int[] res = {m + 1, n + 1};
				return res;
			}
		}
		return new int[0];
	}

	public int[] twoSum(int[] nums, int target) {//非排序
		if(nums == null || nums.length < 2){
			return new int[2];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int left = 0, right = 0;
		for (int i = 0; i < nums.length; i++){
			map.put(nums[i], i);//将数组的值作为key，索引作为value
		}
		for (int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
				left = i;
				right = map.get(target - nums[i]);
				break;
			}
		}
		int[] result = {left, right};
		return result;
	}

	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
