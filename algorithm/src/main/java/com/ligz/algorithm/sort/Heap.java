package com.ligz.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * author:ligz
 */
public class Heap implements Sort{

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int N = arr.length - 1;

        for (int k = N / 2; k >= 1; k--) {//构造堆有序化
            sink(arr, k, N);
        }

        while (N > 1) {//构造数组有序
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
        return arr;
    }

    private void exch(int[] arr, int i, int j) { int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp; };

    private void sink(int[] arr, int i, int j) {
        while (i * 2 <= j) {
            int temp = i * 2;
            if (temp < j && arr[temp] < arr[temp + 1]) temp++;
            if (arr[i] >= arr[temp]) break;
            exch(arr, i, temp);
            i = temp;
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] nums = {5,2,7,3,6,1,4};
        heap.sort(nums);
    }
}
