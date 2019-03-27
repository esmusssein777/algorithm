package com.ligz.offer;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * author:ligz
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //确定窗口两边，来计算里面的和
        int left = 1, right = 2;
        while (left < right) {
            int cur = (left + right) * (right - left + 1) / 2;//计算和，公式是(a+b)*n /2  n是b和a之间的距离
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int num = left; num <= right; num++) {
                    list.add(num);
                }
                lists.add(list);
                left++;
            } else if (cur < sum) {
                right++;
            } else {
                left++;
            }
        }
        return lists;
    }

}
