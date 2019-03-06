package com.ligz.algorithm.array;

import java.util.Arrays;

/**
 * author:ligz
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
