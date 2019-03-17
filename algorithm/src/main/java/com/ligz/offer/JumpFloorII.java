package com.ligz.offer;

import java.util.Arrays;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * author:ligz
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        int[] nums = new int[target + 1];
        Arrays.fill(nums, 0);
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < target + 1; i++) {
            if (nums[i] != 0) continue;
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j];
            }
        }
        return nums[target];
    }

    public static void main(String[] args) {
        JumpFloorII j = new JumpFloorII();
        System.out.println(j.JumpFloorII(2));
    }
}
