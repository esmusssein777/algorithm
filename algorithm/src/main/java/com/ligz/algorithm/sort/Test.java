package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * @author ligz
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(">================冒泡================<");
		int[] array = {6,5,4,3,2,1};
		int[] array2 = {8,5,9,4,3,1,6,8,4,1};
		Sort bubble = new Bubble();
		System.out.println(Arrays.toString(bubble.sort(array)));
		System.out.println(Arrays.toString(bubble.sort(array2)));
		
		System.out.println(">================选择================<");
		Sort select = new Selection();
		System.out.println(Arrays.toString(select.sort(array)));
		System.out.println(Arrays.toString(select.sort(array2)));
		
		System.out.println(">================插入================<");
		Sort insert = new Insert();
		System.out.println(Arrays.toString(insert.sort(array)));
		System.out.println(Arrays.toString(insert.sort(array2)));
		
		System.out.println(">================希尔================<");
		Sort shell = new Shell();
		System.out.println(Arrays.toString(shell.sort(array)));
		System.out.println(Arrays.toString(shell.sort(array2)));
		
		System.out.println(">================归并================<");
		Sort merge = new Merge();
		System.out.println(Arrays.toString(merge.sort(array)));
		System.out.println(Arrays.toString(merge.sort(array2)));

		String s = "asd";
	}

}
