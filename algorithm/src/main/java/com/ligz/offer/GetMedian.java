package com.ligz.offer;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 * author:ligz
 */
public class GetMedian {
    int n = 0;
    PriorityQueue<Integer> left = new PriorityQueue<>((n1, n2) -> (n2 - n1));//大顶堆
    PriorityQueue<Integer> right = new PriorityQueue<>();//小顶堆

    public void Insert(Integer num) {
        /* 插入要保证两个堆存于平衡状态 */
        if (n % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.offer(num);
            right.offer(left.poll());
        } else {
            right.offer(num);
            left.offer(right.poll());
        }
        n++;
    }

    public Double GetMedian() {
        if (n % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }

}
