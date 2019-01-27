package com.ligz.algorithm.array.doublepointer;

/**
 * 翻转字符
 * author:ligz
 */
public class ReverseStr {
	public String reverseString(String s) {
		if(s == null || "".equals(s)){
			return "";
		}
		char[] str = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j){
			swap(str, i, j);
			i++;
			j--;
		}
		return new String(str);
	}

	private void swap(char[] str, int i, int j){
		char s = str[i];
		str[i] = str[j];
		str[j] = s;
	}

	public static void main(String[] args) {
		String s = "hello";
		ReverseStr reverseStr = new ReverseStr();
		System.out.println(reverseStr.reverseString(s));
	}
}
