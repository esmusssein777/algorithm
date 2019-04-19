package com.ligz.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * author:ligz
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {//暴力解法
        int len = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4 && j < len; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, len);
                    if (valid(a) && valid(b) && valid(c) && valid(d)) {
                        list.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return list;
    }

    private boolean valid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
