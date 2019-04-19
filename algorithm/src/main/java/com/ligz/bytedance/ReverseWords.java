package com.ligz.bytedance;

/**
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 2
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * author:ligz
 */
public class ReverseWords {
    public String reverseWords(String s) {
        int len = s.length();
        int i = 0, j = 0;
        char[] c = s.toCharArray();
        //翻转每个单词
        while (j <= len) {
            if (j == len || c[j] == ' ') {
                reverse(c, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        //翻转整个句子
        reverse(c, 0, len - 1);
        i = 0;
        j = 0;
        //去除多余的空格
        while (j < len) {
            while (j < len && c[j] == ' ') j++;//跳过开头的空格
            while (j < len && c[j] != ' ') c[i++] = c[j++];//保留单词
            while (j < len && c[j] == ' ') j++;//通过结尾的空格
            if (j < len) c[i++] = ' ';//保留一个空格
        }
        return new String(c).substring(0, i);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char ch = c[i];
            c[i] = c[j];
            c[j] = ch;
            i++;j--;
        }

    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("blue is sky the"));
    }
}
