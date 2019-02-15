package com.ligz.algorithm.binarysearch;

/**
 * x 的平方根
 * author:ligz
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;//设置0会出现问题
        int right = x;
        int result = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid == x / mid) return mid;//运用除非，否则需要将int改为long
            if(mid < x / mid){
                left = mid + 1;
                result = mid;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/*    public int mySqrt(int x) {//二分查找
        long left = 0;
        long right = x;
        while (left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid == x) return (int)mid;
            if(mid * mid < x){
                long temp = mid + 1;
                if(temp * temp > x){//需要判断右边的一个数是不是大于，如果大于，那么返回
                    return (int)mid;
                }else {
                    left = mid + 1;
                }
            }else {
                long temp = mid - 1;
                if(temp * temp < x){
                    return (int)mid - 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }*/
