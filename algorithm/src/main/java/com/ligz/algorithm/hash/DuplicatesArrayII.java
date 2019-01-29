package com.ligz.algorithm.hash;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * author:ligz
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class DuplicatesArrayII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - k -1]);
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
