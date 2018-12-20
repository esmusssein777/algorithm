package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author ligz
 */
public class Merge implements Sort{

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		if(array.length < 2) {
			return array;
		}
		int mid = (int)Math.floor(array.length / 2);
		
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		//递归，空间复杂度为O(n),而不是O(1)
		return merge(sort(left), sort(right));
	}
	
	private int[] merge(int[] left, int[] right) {
		int result[] = new int[left.length + right.length];
		int i = 0;
		while(left.length > 0 && right.length > 0) {
			if(left[0] <= right[0]) {
				result[i++] = left[0];
				//将已经加到上一层的left[0]从里面去除
				left = Arrays.copyOfRange(left, 1, left.length);
			}else {
				result[i++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		//最后剩了一个left或者right的时候是最大值，加进去
		while(left.length > 0) {
			result[i++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		
		while(right.length > 0) {
			result[i++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		
		return result;
	}


}
