package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 假设第一个数有序，其他无序的数向前插入
 * @author ligz
 */
public class Insert implements Sort{
	@Override
	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		for(int i = 1; i < array.length; i++) {
			//用一个数来记录将要插入的数
			int temp= array[i];
			int j = i;
			//前面的数已经有序了，只要小于前面一个数即可
			while(j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			if(j != i) {
				array[j] = temp;
			}
		}
		return array;
	}

}
