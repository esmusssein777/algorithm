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
	}

}
