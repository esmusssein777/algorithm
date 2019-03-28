package com.ligz.offer;

/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * author:ligz
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || "".equals(str)) return 0;
        boolean flag = str.charAt(0) == '-';//判断是否是负数
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) continue;//如果第一个是 + 或者 - 就不管
            if (c < '0' || c > '9') return 0;//非法字符直接为 0
            res = res * 10 + (c - '0');
        }
        return flag ? -res : res;
    }
}
