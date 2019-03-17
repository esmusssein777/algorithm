package com.ligz.datastructure.queue;

/**
 * 优先队列，用堆来实现
 * author:ligz
 */
public class MyPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;//基于堆的完全二叉树
    private int N = 0;//存储于pq[1,N]中，pq[0]没有使用

    public MyPriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){ return N == 0; };

    public int size() { return N; };

    public void insert(Key key) {//这个思路就是加到最后面，将他上浮
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {//将最大跟节点的和最后面的交换，再将这个交换了的元素下沉
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) { return pq[i].compareTo(pq[j]) < 0; }

    private void exch(int i, int j) { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }

    private void swim(int k) {//上浮
        while (k > 1 && less(k / 2, k)) {//比父节点大就行
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {//下沉
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k , j);
            k = j;
        }
    }

}
