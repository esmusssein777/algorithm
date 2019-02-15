package com.ligz.algorithm.binarysearch;

/**
 * 搜索旋转排序数组
 * author:ligz
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class RotatedSearch {
    public int search(int[] nums, int target) {//第一种解法，找到最小值，找到真正的中点索引
        int left = 0, right = nums.length - 1;
        while (left < right){//首先找到最小值的下标
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        int min = left;//数组中最小值的索引
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int readMid = (mid + min) % nums.length;//利用最小值获取真实的下标
            if (nums[readMid] == target) return readMid;
            if (nums[readMid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            //判断target和中点是否在同一侧
            if((nums[mid] < nums[0]) != (target < nums[0])){
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if(num == target) return mid;
            if(num > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
