package com.ligz.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * author:ligz
 */
public class Partition {
    List<List<String>> res;
    ArrayList<String> cur;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        backTrace(s, 0);
        return res;
    }

    private void backTrace(String s, int index) {
        if (cur.size() > 0 && index >= s.length()) {
            List<String> r = (ArrayList<String>) cur.clone();
            res.add(r);
            //.clear();
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                if (index == i)
                    cur.add(Character.toString(s.charAt(i)));
                else
                    cur.add(s.substring(index, i + 1));
                backTrace(s, i + 1);
                cur.remove(cur.size() -1);
            }
        }
    }


    public boolean isPalindrome(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        p.partition("aab");
    }
}
