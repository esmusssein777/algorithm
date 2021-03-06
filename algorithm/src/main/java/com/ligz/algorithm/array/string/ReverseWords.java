package com.ligz.algorithm.array.string;

/**
 *  反转字符串中的单词 III
 *
 *  给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @author: ligz
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = swap(str[i].toCharArray());
        }
        String res = "";
        for (int i = 0; i < str.length - 1; i++) {
            res += str[i] + " ";
        }
        return res + str[str.length - 1];
    }

    private String swap(char[] ch) {
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;right--;
        }
        return new String(ch);
    }
}
