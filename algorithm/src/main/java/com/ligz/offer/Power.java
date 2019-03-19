package com.ligz.offer;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * author:ligz
 * x^exp = (x * x) ^ (exp / 2) n为偶数
 * x^exp = x * [(x * x) ^ (exp / 2)] n为奇数
 */
public class Power {
    //因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        boolean flag = false;
        if (exponent < 0) {//可能出现为 负的指数级，如果为负数，那么就为 1/base^exp
            flag = true;
            exponent = -exponent;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {//如果exp为单数，那么还要乘一次base
            pow = pow * base;
        }
        return flag ? 1 / pow : pow;
    }
}
