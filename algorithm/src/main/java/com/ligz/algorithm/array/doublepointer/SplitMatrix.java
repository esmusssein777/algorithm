package com.ligz.algorithm.array.doublepointer;

import java.util.Arrays;

/**
 * 数组拆分
 * author:ligz
 */
public class SplitMatrix {

	public int arrayPairSum2(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i += 2) {
			count += nums[i];
		}
		return count;
	}


	public int arrayPairSum(int[] nums) {
		int count = 0;//总数
		//数组没有排序，先排序
		for(int i = 1; i < nums.length; i++){//冒泡
			boolean flag = true;
			for(int j = 0; j < nums.length - i; j++){
				if(nums[j] > nums[j+1]){
					swap(nums, j, j + 1);
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
		//遍历完后+2索引将值加起来
		for(int i = 0; i < nums.length; i = i+2){
			count += nums[i];
		}
		return count;
	}

	private void swap(int nums[], int i, int j){
		int num = nums[i];
		nums[i] = nums[j];
		nums[j] = num;
	}
}
