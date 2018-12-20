package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author ligz
 */
public class Shell implements Sort{

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
        	
        	for(int i = gap; i < array.length; i++) {
        		int temp = array[i];
        		int j = i - gap;
        		while(j >= 0 && temp < array[j]) {
        			array[j+gap] = array[j];
        			j -= gap;
        		}
        		array[j + gap] = temp;
        	}
        }

        return array;
    }
	
	public static void main(String[] args) {
		Shell s = new Shell();
		int[] array = {9,8,7,6,5,4,3,2,1,0};
		int[] array2 = {8,4,4,6,8,1,3,2,1,9};
		int[] array3 = {11,34,31,21,65};
		System.out.println(Arrays.toString(s.sort(array)));
		System.out.println(Arrays.toString(s.sort(array2)));
		System.out.println(Arrays.toString(s.sort(array3)));
	}

}
