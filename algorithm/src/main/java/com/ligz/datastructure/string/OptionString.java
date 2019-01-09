package com.ligz.datastructure.string;

/**
 * author:ligz
 */
public class OptionString {
	public static void main(String[] args) {
		String s1 = "Hello World";
		// 1. concatenate
		s1 += "!";
		System.out.println(s1);
		// 2. find
		System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
		System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
		// 3. get substring
		System.out.println(s1.substring(6, 11));
	}
}
