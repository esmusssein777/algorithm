package com.ligz.algorithm.binarysearch;

/**
 * 寻找峰值
 * author:ligz
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 1, right = nums.length - 2;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;


        }
        return -1;
    }
}
