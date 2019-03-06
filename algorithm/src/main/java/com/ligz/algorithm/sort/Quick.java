package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * @author ligz
 */
public class Quick implements Sort {
	@Override
	public int[] sort(int[] sourceArray) {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		return quickSort(arr, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int p = pIndex(arr, left, right);
			quickSort(arr, left, p - 1);
			quickSort(arr, p + 1, right);
		}
		return arr;
	}

	private int pIndex(int[] arr, int left, int right) {
		int p = left;
		int index = p + 1;
		for (int i = index; i <= right; i++) {
			if (arr[i] < arr[p]) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, p, index - 1);
		return index - 1;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int array[] = { 3, 5, 8, 1, 2, 9, 4, 7, 6 };
		Sort q = new Quick();
		
		System.out.println(Arrays.toString(q.sort(array)));
	}

}
