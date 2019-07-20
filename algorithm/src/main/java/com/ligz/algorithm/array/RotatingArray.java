package com.ligz.algorithm.array;

/**
 * 旋转数组
 * author:ligz
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class RotatingArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		for(int i = 0; i < k; i++){
			int temp = nums[len - 1];
			for(int j = len - 1; j > 0; j--){
				nums[j] = nums[j - 1];
			}
			nums[0] = temp;
		}
	}

	/**
	 * 翻转
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public void rotate_2(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}


	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	/**
	 * 目标：如何才能在 Time=O(n),Space=O(1)的情况解决右移 k 位
	 * 分析：发现右移可以通过旋转数组来实现，那是先旋转整个数组还是先旋转一部分呢？都可以，不过解法有区别
	 * 错误：没有将 k % len,疏忽了这种情况
	 * 关键：将右移问题变成旋转数组问题
	 * Time=O(n),Space=O(1)
	 */
	public void rotate3(int[] nums, int k) {
		int len = nums.length;
		int index = len - (k % len)  - 1;
		swap(nums, 0, index);
		swap(nums, index + 1, len - 1);
		swap(nums, 0, len - 1);
	}

	private void swap(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;right--;
		}
	}



	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		RotatingArray array = new RotatingArray();
		//array.rotate(nums, 3);
		array.rotate_2(nums, 3);
	}
}
