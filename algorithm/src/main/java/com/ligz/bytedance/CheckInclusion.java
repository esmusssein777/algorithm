package com.ligz.bytedance;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * author:ligz
 */
public class CheckInclusion {
    boolean flag = false;
    public boolean checkInclusion(String s1, String s2) {// time O(n!)  space O(n^2) 超出时间限制
        if (s1 == null || s2 == null || s2.length() == 0) return false;
        check(s1.toCharArray(), s2, 0, s1.length() - 1);
        return flag;
    }

    private void check(char[] array, String s2, int start, int end) {
        //从字符串中选出一个字符作为排列的第一个字符，然后对剩余的字符进行全排列。如此递归处理，从而得到所有字符的全排列。
        if (start == end) {
            if (s2.indexOf(String.valueOf(array)) >= 0) flag = true;
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, i, start);
                check(array, s2, start + 1, end);
                swap(array, i, start);
            }
        }
    }

    private void swap(char[] array, int m, int n) {
        char c = array[m];
        array[m] = array[n];
        array[n] = c;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        checkInclusion.checkInclusion("abc", "eidbaooo");
    }



    public boolean checkInclusion2(String s1, String s2) {//leetcode
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] array = new int[26];
        for (int i = 0; i < len1; i++) {
            array[s1.charAt(i) - 'a']++;
            array[s2.charAt(i) - 'a']--;
        }
        if (check(array)) return true;

        for (int i = len1; i < len2; i++) {
            array[s2.charAt(i) - 'a']--;
            array[s2.charAt(i - len1) - 'a']++;
            if (check(array)) return true;
        }
        return false;
    }

    public boolean check(int[] array) {
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) return false;
        }
        return true;
    }
}
