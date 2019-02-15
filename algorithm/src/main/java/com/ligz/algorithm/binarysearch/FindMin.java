package com.ligz.algorithm.binarysearch;

/**
 * 寻找旋转排序数组中的最小值
 * author:ligz
 * 输入: [4,5,6,7,0,1,2] 4 5 6 0 1 2 3
 * 输出: 0
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
