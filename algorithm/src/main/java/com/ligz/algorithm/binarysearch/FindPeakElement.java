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
        int left = 0, right = nums.length - 1;
        if(nums.length == 1){
            return 0;
        }
        while (left + 1 < right){
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return (left == nums.length - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
