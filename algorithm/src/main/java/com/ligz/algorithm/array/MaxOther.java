package com.ligz.algorithm.array;

/**
 *  至少是其他数字两倍的最大数
 * @author ligz
 */
public class MaxOther {
	public int dominantIndex(int[] nums) {
		int max = nums[0];
		int index = 0;
		int count = 0;
        for(int i = 1; i < nums.length; i++) {//遍历所有，找出最大的数和索引
        	if(max < nums[i]) {
        		max = nums[i];
        		index = i;
        	}
        }
        for(int i = 0; i < nums.length; i++) {//判断是否最大的数是否大于所有的数的两倍
        	if(max >= nums[i] * 2) {
        		count++;
        	}
        }
        if(count == nums.length - 1) {//如果大于全部的数，则返回
        	return index;
        }
        return -1;
    }
}
