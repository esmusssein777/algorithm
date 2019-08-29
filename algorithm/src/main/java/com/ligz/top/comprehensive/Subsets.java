package com.ligz.top.comprehensive;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    /**
     * 目标：列出所有的子集
     * 分析：如何使用回溯法，可以把他看做是树，左子树是不选，右子树是选择，那么只要选择一种前序还是后序就ok
     * 错误：没有加一个 null 的list
     * 关键：把这个回溯看做是遍历树，选择与不选择子元素看做是树的两边
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        pre(nums, 0, new ArrayList<Integer>(), lists);
        lists.add(new ArrayList<Integer>());
        return lists;
    }

    public void pre(int[] nums, int i, List<Integer> list, List<List<Integer>> lists) {
        if (i >= nums.length) return;
        list = new ArrayList<Integer>(list);
        lists.add(list);
        pre(nums, i + 1, list, lists);
        list.add(nums[i]);
        pre(nums, i + 1, list, lists);
    }
}
