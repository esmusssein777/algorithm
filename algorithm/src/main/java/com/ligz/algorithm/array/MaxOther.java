package com.ligz.algorithm.array;

/**
 *  至少是其他数字两倍的最大数
 * @author ligz
 */
public class MaxOther {
	/**
	 * 目标：如何找出比所有其他数都大2倍的索引
	 * 分析：想要简单一些的话，不要再次遍历一遍，判断比所有其他的数都要大两倍。直接判断是否会比其他的数的两倍要小
	 * 错误：低级的错误，代码冗余
	 * 关键：只要有小于的直接返回，代码简单
	 * Time=O(n);Space=O(1);
	 */
	public int dominantIndex3(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[index]) {//计算最大值的索引 index
				index = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {//如果最大的index小于某一个的2倍，直接返回 -1
			if (i != index && nums[index] < nums[i] * 2) {
				return -1;
			}
		}
		return index;
	}


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

	/**
	 * O(N),O(1)
	 * @param nums
	 * @return
	 */
	public int dominantIndex2(int[] nums) {
		int maxIndex = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
		}
		for (int i = 0; i < nums.length; ++i) {//确实，只需要有小于的就可以返回
			if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
				return -1;
		}
		return maxIndex;
	}
}
