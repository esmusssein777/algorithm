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

    /**
     * 上面的代码还是有问题，int 转为 long
     * 问题出在 n = - n 上，数值范围是 [−2^31, 2^31 − 1]
     */
    public double myPow2(double x, int n) {//需要把 int 转为 long ，否则会栈溢出
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double result = fastPow(x, n);

        return flag ? 1 / result : result;
    }

    public double fastPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double result =  fastPow(x * x, n / 2);
        if (n % 2 != 0) {
            result = x * result;
        }
        return result;
    }


    /**
     * 自己的解法，没有必要这样，只需要判断是奇次方还是偶次方在最后再乘一次即可
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        x = pow(x, n);
        if (flag) {
            return 1 / x;
        }
        return x;
    }

    public double pow(double x, int n) {
        if (n == 1) return x;
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x, n - 1);
        }
    }
}
