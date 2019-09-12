package com.ligz.algorithm.array;

/**
 * 最长回文字符串
 * author:ligz
 * 输入abba
 * 输出bb
 */
public class MaxParStr {
    private int left, len;

    public String max(String s){
        int l = s.length();
        if (l < 2) return s;
        for (int i = 0; i < l - 1; i++){
            extend(s, i ,i);
            extend(s, i, i + 1);
        }
        return s.substring(left, left + len);
    }

    public void extend(String s, int j, int k){
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (len < k - j -1) {
            left = j + 1;
            len = k - j - 1;
        }
    }
}
