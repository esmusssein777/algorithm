package com.ligz.algorithm.array.doublepointer;

/**
 * 两数之和
 * author:ligz
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class NumSum {
	public int[] twoSum(int[] numbers, int target) {

		for(int i = 0; i < numbers.length - 1; i++){
			for(int j = i + 1; j < numbers.length; j++){
				if(numbers[i] + numbers[j] == target){
					int[] index = {i + 1, j + 1};
					return index;
				}
			}
		}
		return new int[0];
	}

	public int[] twoSum2(int[] num, int target) {//leetcode
		int[] indice = new int[2];
		if (num == null || num.length < 2) return indice;
		int left = 0, right = num.length - 1;
		while (left < right) {
			int v = num[left] + num[right];
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (v > target) {
				right --;
			} else {
				left ++;
			}
		}
		return indice;
	}
}
