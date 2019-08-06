package com.ligz.top.comprehensive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * @author: ligz
 */
public class ThreeSum {
    /**
     * 目标：我们以前写过两个数求和，用的是map就可以解决。现在三个数和为0，该如何？
     * 分析：使用哈希不好写，暴力法太low，先排序，可以转化成双指针。
     * 错误：去重的边界如何判断错误，三次去重，i、left、right都要去重
     * 关键：确定双指针写法，左右指针指向nums[i]的两端边界。做好去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
