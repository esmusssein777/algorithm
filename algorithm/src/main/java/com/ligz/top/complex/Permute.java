package com.ligz.top.complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: ligz
 */
public class Permute {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return lists;
        order(nums, 0);
        return lists;
    }

    public void order(int[] nums, int i) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            lists.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                order(nums, i + 1);
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute p = new Permute();
        p.permute(nums);
    }
}
