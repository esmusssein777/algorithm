package com.ligz.algorithm.array.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 实现strStr()
 * 查找字符串
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * author:ligz
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
		if(needle == null && "".equals(needle)){//如果字符为空，那么返回0
			return 0;
		}
		if(needle.length() > haystack.length()){//如果后面的字符更长，那么肯定没有相同的
			return -1;
		}
		char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();
		for(int i = 0; i < h.length - n.length + 1; i++){//遍历第一个字符
			boolean flag = true;
			for(int j = 0; j < n.length; j++){//从索引0开始，寻找和第二个字符相同的大小的字符是否都相同
				if(h[i+j] != n[j]){//如果不同，则为false
					flag = false;
				}
			}
			if(flag == true){//如果都相同，那么就返回当前的索引
				return i;
			}
		}
		return -1;
	}

	/**
	 * LeetCode大神
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr2(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int size = sc.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < size; i++) {
				String str = sc.nextLine();
				String[] s = str.split(" ");
				int key = Integer.parseInt(s[0]);
				int value = Integer.parseInt(s[1]);
				if (!map.containsKey(key)) {
					map.put(key, value);
				} else {
					map.put(key, map.get(key) + value);
				}
			}
			for (Map.Entry entry : map.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}
}
