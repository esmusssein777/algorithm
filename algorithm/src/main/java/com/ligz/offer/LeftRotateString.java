package com.ligz.offer;

/**
 * 左旋转字符串
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 *
 * 假如是右移翻转成 defabcXYZ要如何？
 * author:ligz
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || "".equals(str)) return "";
        int len = str.length();
        char[] ch = str.toCharArray();
        //左移和右移的顺序是不一样的，左移是先翻转两边，再整个翻转。而右移是先整个翻转，两边再分别翻转
        reverse(ch, 0, n%len - 1);
        reverse(ch, n%len, len - 1);
        reverse(ch, 0, len - 1);
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

}
