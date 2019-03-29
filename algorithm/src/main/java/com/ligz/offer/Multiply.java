package com.ligz.offer;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 * author:ligz
 */
public class Multiply {
    public int[] multiply(int[] A) {//如果是想要相乘，，需要O(n^2)，我们需要O(n)
        int len = A.length;
        int[] B = new int[len];

        for (int i = 0, mul = 1; i < len; i++) {//先从左往右相乘，不要当前的
            B[i] = mul;
            mul *= A[i];
        }

        for (int i = len - 1, mul = 1; i >= 0; i--) {//从右往左乘过来
            B[i] *= mul;
            mul *= A[i];
        }
        return B;
    }
}
