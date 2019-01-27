package com.ligz.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个列表的最小索引总和
 * author:ligz
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class MinIndex {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		for (int i = 0; i < list1.length; i++){
			map1.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++){
			map2.put(list2[i], i);
		}
		int min = Integer.MAX_VALUE;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < list1.length; i++){
			if(map2.containsKey(list1[i])){//在hashmap中查找相同的key值
				int sum = map2.get(list1[i]) + i;
				if(sum < min){
					list.clear();
					list.add(list1[i]);
					min = sum;
				}else if(sum == min){
					list.add(list1[i]);
				}
			}
		}
		String[] result = new String[list.size()];
		for(int i = 0; i < list.size(); i++){
			result[i] = list.get(i);
		}
		return result;
	}
}
