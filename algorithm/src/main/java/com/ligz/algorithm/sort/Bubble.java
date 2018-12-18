package com.ligz.algorithm.sort;

/**
 * 冒泡
 * 两两对比，交换位置
 * @author ligz
 */
public class Bubble implements Sort{

	public int[] sort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			boolean flag = true;
			
			for(int j = 0; j < array.length - i; j++) {
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
