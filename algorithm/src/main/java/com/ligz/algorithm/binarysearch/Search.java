package com.ligz.algorithm.binarysearch;

import java.util.Arrays;

/**
 * 二分查找
 * author:ligz
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Search {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
/*    int res = -1;
    public int search(int[] nums, int target) {
        binary(nums, target, 0);
        return res;
    }

    public void binary(int[] nums, int target, int mid) {
        int index = nums.length / 2;
        if(index == 0){
            if (nums[index] != target) return;
        }
        if(nums[index] > target) binary(Arrays.copyOfRange(nums, 0, index), target, mid);
        if(nums[index] < target) binary(Arrays.copyOfRange(nums, index, nums.length), target, mid + index);
        if(nums[index] == target) res = index + mid;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        Search search = new Search();
        System.out.println(search.search(nums, 2));
    }*/