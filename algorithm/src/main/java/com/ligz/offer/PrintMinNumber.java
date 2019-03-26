package com.ligz.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * author:ligz
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] nums = new String[len];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (n1, n2) -> (n1 + n2).compareTo(n2 + n1));
        String str = "";
        for (String s : nums) {
            str += s;
        }
        return str;
    }
}
