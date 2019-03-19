package com.ligz.offer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * author:ligz
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] seq, int left, int right) {
        if (right - left <= 1) return true;
        int mid = seq[right];
        int min = left;
        while (min < right && seq[min] <= mid) min++;
        for (int i = min; i < right; i++) {
            if (seq[i] < mid) return false;
        }
        return verify(seq, left, min - 1) && verify(seq, min, right - 1);
    }
}
