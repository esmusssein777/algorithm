package com.ligz.top.comprehensive;

/**
 * 买卖股票的最佳时机
 * @author: ligz
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class MaxProfit {
    /**
     * 我们可以维持两个变量—— min 和 max，
     * 它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                if (price - min > max) {
                    max = price - min;
                }
            }
        }
        return max;
    }
}
