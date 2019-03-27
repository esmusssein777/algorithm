package com.ligz.offer;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数
 * author:ligz
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {//这种二叉搜索可以分析最左和左右的情况
        int first = binarySearch(array, k);
        int last = binarySearch(array , k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) h = m;
            else l = m + 1;
        }
        return l;
    }

    public int GetNumberOfK2(int [] array , int k) {
        int len = array.length;
        int index = search(array, 0, len - 1, k);//先二分查找，再去左右两边找
        if (index == -1) return 0;
        int count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == k) count++;
            else break;
        }
        for (int i = index + 1; i < len; i++) {
            if (array[i] == k) count++;
            else break;
        }
        return count;
    }

    private int search(int[] array, int left, int right, int k) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) return mid;
            else if (array[mid] < k) right = mid;
            else left = mid + 1;
        }
        return -1;
    }


}
