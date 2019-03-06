package com.ligz.algorithm.array;

/**
 * 移动零
 * author:ligz
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}
