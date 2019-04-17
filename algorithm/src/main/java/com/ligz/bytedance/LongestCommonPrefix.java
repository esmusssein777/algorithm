package com.ligz.bytedance;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * author:ligz
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //重头到尾会出现某个index大的情况，所以我们用减的方式
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.length() == 0) return "";
            }
        }
        return pre;
    }
}
