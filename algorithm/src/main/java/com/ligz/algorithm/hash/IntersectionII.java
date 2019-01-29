package com.ligz.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II
 * author:ligz
 * 给定两个数组，编写一个函数来计算它们的交集,不同之前的是
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class IntersectionII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++){//将nums1的每个数字为key,将有多少个重复的作为value
            if(map1.containsKey(nums1[i])){
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }else {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++){//nums2同理
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }else {
                map2.put(nums2[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()){//将最相同的作为交集，将最小的个数放入list
            if(map2.containsKey(entry.getKey())){
                for(int i = 0; i < Math.min(entry.getValue(), map2.get(entry.getKey())); i++){
                    list.add(entry.getKey());
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer val : list){
            result[i++] = val;
        }
        return result;
    }
}
