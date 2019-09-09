package com.ligz.algorithm.array.doublepointer;

/**
 * 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 */
public class RemoveElement {
	/**
	 * 目标：移除所有数值等于 val 的元素
	 * 分析：可以使用双指针来找
	 * 错误：创建一个新的数组之类
	 * 关键：一个指针指向最新的，一个指针指向去除了元素后的地方
	 * Time=O(n),Space=O(1)
	 */
	public int removeElement(int[] nums, int val) {
		int m = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[m] = nums[i];
				m++;
			}
		}
		return m;
	}
}
