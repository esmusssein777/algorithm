package com.ligz.algorithm.hash;

import java.util.*;

/**
 * 字母异位词分组
 * author:ligz
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++){
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < strs[i].length(); j++){//将字母放入list中排序，将他们组成同样的字符放入map中
                list.add(strs[i].charAt(j));
            }
            Collections.sort(list);
            String anagrams = "";
            for (Character c : list){
                anagrams += c;
            }
            if(map.containsKey(anagrams)){//放入对应的list中
                result.get(map.get(anagrams)).add(strs[i]);
            }else {
                map.put(anagrams, index);//根据index放入对应的list中
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                result.add(index, stringList);
                index++;
            }
        }
        return result;
    }
}
