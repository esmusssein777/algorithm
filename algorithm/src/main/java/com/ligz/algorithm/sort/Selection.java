package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 找出最小/最大，放置，重复
 * @author ligz
 */
public class Selection implements Sort{
	@Override
	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		int length = array.length;
		//N-1轮
		for(int i = 0; i < length-1; i++) {
			int min = i;
			//N-i轮
			for(int j = i + 1; j < length; j++) {
				//使用下标来记录数组的数据
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

}
