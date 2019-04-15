package com.ligz.algorithm.array;

/**
 * 寻找重复的
 * author:ligz
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int res = 0;
        int temp = 0;
        for (int n : nums) {
            temp = res;
            res = res ^ n;
            if (res < temp) return n;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindDuplicate duplicate = new FindDuplicate();
        int[] nums = {1,3,4,2,2};
        duplicate.findDuplicate(nums);
    }
}
