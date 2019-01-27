package com.ligz.algorithm.hash;

import java.util.HashSet;

/**
 * 存在重复元素
 * author:ligz
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class DuplicatesArray {
	public boolean containsDuplicate(int[] nums) {//使用哈希集合来存放，有相同的true
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(set.contains(nums[i])){
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
