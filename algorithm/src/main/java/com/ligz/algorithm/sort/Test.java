package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * @author ligz
 */
public class Test {
	public static void main(String[] args) {
		int[] array = {6,5,4,3,2,1};
		int[] array2 = {8,5,9,4,3,1,6,8,4,1};
		Sort bubble = new Bubble();
		System.out.println(Arrays.toString(bubble.sort(array)));
		System.out.println(Arrays.toString(bubble.sort(array2)));
	}

}
