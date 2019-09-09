package com.ligz.algorithm.array.string;

/**
 * 查找字符串数组中的最长公共前缀
 * author:ligz
 */
public class PrefixStr {
	/**
	 * 目标：查找字符串数组中的最长公共前缀
	 * 分析：选择一个String作为基础，遍历判断是否是子元素
	 * 错误：不可以从头开始遍历，需要判断最小的String的长度
	 * 关键：如何遍历需要想好，不容易想的到
	 * Time=O(n),Space=O(1)
	 */
	public String longestCommonPrefix2(String[] strs) {
		//重头到尾会出现某个len大的情况，所以我们用减的方式
		if (strs == null || strs.length == 0) return "";
		String pre = strs[0];
		for (int i = 0; i < strs.length; i++) {
			while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
				if (pre.length() == 0) return "";
			}
		}
		return pre;
	}
	/**
	 * 官方2
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix3(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i = 0; i < strs[0].length() ; i++){
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j ++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}
