package com.ligz.bytedance;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * author:ligz
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        //num1[i] * num2[j] 的乘积会在数组的 [i + j, i + j + 1]
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 =  j + i, p2 = j + i + 1;
                mul += pos[p2];

                pos[p1] += mul / 10;
                pos[p2] = mul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
