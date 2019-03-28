package com.ligz.offer;

/**
 * 翻转单词顺序列
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 * author:ligz
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        int len = str.length();
        char[] c = str.toCharArray();
        int i = 0, j = 0;
        while (j <= len) {//先旋转每个单词，再旋转整个字符串
            if (j == len || c[j] == ' ') {
                reverse(c, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(c, 0, len - 1);
        return new String(c);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;j--;
        }
    }
}


