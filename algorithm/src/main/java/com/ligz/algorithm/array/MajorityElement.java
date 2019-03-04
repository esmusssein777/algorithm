package com.ligz.algorithm.array;

/**
 * 求众数
 * author:ligz
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 输入: [3,2,3]
 * 输出: 3
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {//摩尔投票法
        int index = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) index++;
            if (res != nums[i]) {
                index--;
                if (index == 0) {
                    res = nums[i];
                    index = 1;
                }
            }
        }
        return res;
    }
}
