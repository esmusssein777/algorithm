package com.ligz.top.complex;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @author: ligz
 */
public class IsAnagram {
    /**
     * 目标：判断字母异位词
     * 分析：使用哈希可以成功，但是小写字符可以确定最多 256 个，使用 int[] 更简单、空间复杂度更低。
     * 错误：使用了map,如果是 unicode 的话需要使用 map
     * 关键：判断长度相等，如果相等的话 if (hash[c - 'a'] == 0) return false;
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] == 0) return false;
            hash[c - 'a']--;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        if (map.size() == 0) return true;
        return false;
    }
}
