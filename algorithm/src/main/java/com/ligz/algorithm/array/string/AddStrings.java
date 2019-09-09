package com.ligz.algorithm.array.string;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * author:ligz
 */
public class AddStrings {
    /**
     * 目标：字符串相加
     * 分析：不可以转成long的话，就使用charAt()计算下标
     * 关键：使用StringBuild来记录每一位的结果，最后reverse()
     * Time=O(n),Space=O(n)
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, len1 = num1.length() - 1, len2 = num2.length() - 1;
        while (len1 >= 0 || len2 >= 0 || sum != 0) {
            if (len1 >= 0) sum += num1.charAt(len1--) - '0';
            if (len2 >= 0) sum += num2.charAt(len2--) - '0';
            sb.append(sum%10);
            sum /= 10;
        }
        return sb.reverse().toString();
    }
}
