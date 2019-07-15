package com.ligz.algorithm.array;

/**
 * 寻找数组的中心索引
 * @author ligz
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
 *
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 */
public class MidIndex {
	/**
	 * 自己的答案
	 * Time=O(nlogn) Space=O(1)
	 * @param nums
	 * @return
	 */
	public int pivotIndex(int[] nums) {
		if(nums.length == 0 || nums.length ==1){
			return -1;
		}

		for(int i = 0; i < nums.length; i++){//暴力循环，索引递增，然后计算左右的值
			int left = 0;
			int right = 0;
			for(int j = 0; j < i; j++){//计算左右值相等
				left += nums[j];
			}
			for(int j = i + 1; j < nums.length; j++){
				right += nums[j];
			}
			if(left == right){
				return i;
			}
		}
		return -1;
	}


	/**
	 * 目标：如何返回中心，如何在复杂度上减少
	 * 分析：像上面那样的解法是肯定是不行的，想要时间复杂度简单，就需要先算一遍 count，才可能在 O(n)解决
	 * 错误：用了除法，不行，因为 5 / 2 这种会出现错误。
	 * 错误：在大于的时候做了判断 break，在数组为负数的时候错误
	 * 关键：复杂度需要低，而且在做之前考虑不同的情况
	 * Time=O(n),Space=O(1)
	 */
	public int pivotIndex2(int[] nums) {
		int sum = 0, leftsum = 0;
		for (int x: nums) sum += x;//先计算总和
		for (int i = 0; i < nums.length; ++i) {//left=sum-left，没有则-1
			if (leftsum == sum - leftsum - nums[i]) return i;
			leftsum += nums[i];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		int[] nums2 = {-1,-1,-1,0,1,1};
		MidIndex m = new MidIndex();
		System.out.println(m.pivotIndex(nums));
		System.out.println(m.pivotIndex(nums2));
	}
}
