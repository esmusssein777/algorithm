package com.ligz.bytedance;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * author:ligz
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = s.length();
        for (int i = 0, j = 0; j < len; j++) {
            //如果不重复，就 j++，i不变。 如果有重复，i 变成当前重复值的下一个索引，同时更新这个重复值在map中的位置
            if (map.containsKey(s.charAt(j))) {//abba
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {//需要先理解上面的再来写下面的要好很多
        int len = s.length();
        int max = 0;
        int[] str = new int[256];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(str[s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            str[s.charAt(j)] = j + 1;
        }
        return max;
    }
}

