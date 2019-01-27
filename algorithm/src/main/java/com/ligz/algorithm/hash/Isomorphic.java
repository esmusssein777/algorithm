package com.ligz.algorithm.hash;

import java.util.*;

/**
 * 同构字符串
 * author:ligz
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身
 * 输入: s = "paper", t = "title"
 * 输出: true
 */
public class Isomorphic {
	public boolean isIsomorphic2(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){//如果存在key相等，判断他们的value是否相等
				if(map.get(s.charAt(i)) != t.charAt(i)){//如果key相等value不相等，为fasle
					return false;
				}
			}else {
				if(map.containsValue(t.charAt(i))){//如果key不相等，value相等，也为false
					return false;
				}
				map.put(s.charAt(i), t.charAt(i));//将 s 的字符当做key,将 t 的字符当做value
			}
		}
		return true;
	}
	public boolean isIsomorphic(String s, String t){
		int[] s1 = new int[256];
		int[] s2 = new int[256];
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		for(int i = 0; i < s.length(); ++i){//如果他们不映射到 0 或者 相同的 i+1 。那么就不是同构
			if(s1[str1[i]] != s2[str2[i]] ) return false;
			s1[str1[i]] = i + 1;
			s2[str2[i]] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		Isomorphic isomorphic = new Isomorphic();
		isomorphic.isIsomorphic("add","egg");
	}

}
