package com.ligz.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * author:ligz
 */
public class Permutation {
    ArrayList list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return list;
        per(str.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }

    private void per(char[] chars, int i) {//这也太抽象了....，每一次的 i 都不一样，j 的起点也不一样
        if (i == chars.length - 1) {
            String str = String.valueOf(chars);
            if (!list.contains(str)) list.add(str);
        } else {
            for (int j = i; j < chars.length; j++) {//顺序为 abc, acb, bac, bca, cba, cab
                swap(chars, i, j);
                per(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.Permutation("abc");
    }
}
