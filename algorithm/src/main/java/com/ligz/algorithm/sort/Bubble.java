package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡
 * 两两对比，交换位置
 * @author ligz
 */
public class Bubble implements Sort{

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
		for(int i = 1; i < array.length; i++) {
			boolean flag = true;
			
			for(int j = 0; j < array.length - i; j++) {//把每一次遍历的最大或最小值放到边上去
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		
		return array;
	}

	

}
