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

        int len = arr.length;

        buildMaxHeap(arr, len);
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {

    }
}
