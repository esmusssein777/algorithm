package com.ligz.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * author:ligz
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){//将字符作为 key，将重复的数量作为 value
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 0);
            }
        }
        for (int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 0){
                return i;
            }
        }
        return -1;
    }
}
