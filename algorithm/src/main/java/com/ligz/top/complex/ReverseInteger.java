package com.ligz.top.complex;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: -123
 * 输出: -321
 */
public class ReverseInteger {
    /**
     * 目标：整数反转
     * 分析：先转成 String 再转成 int
     * 错误：string 转 int 可能会溢出，需要先转成 long 比较一下
     * 关键：注意负数和溢出的排查
     */
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) flag = true;
        String num = String.valueOf(x);
        char[] ch = num.toCharArray();
        if (flag) {
            swap(ch, 1, ch.length - 1);
        } else {
            swap(ch, 0, ch.length - 1);
        }
        long n = Long.valueOf(String.valueOf(ch));
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) return 0;
        return (int) n;

    }

    public void swap(char[] ch, int l, int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }
}
