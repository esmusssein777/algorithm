package com.ligz.algorithm.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环队列
 * author:ligz
 *
 * 最开始使用链表做，太垃圾了，根本不需要删除的。特别是大小确定了基本是要用数组做的
 * 所以再用数组做一遍
 */
public class MyCircularQueue {
	int[] data;
	int start;
	int end;
	int size;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		data = new int[k];
		start = -1;
		end = -1;
		size = k;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if(isFull()){
			return false;
		}
		if(isEmpty()){
			start = 0;
		}
		end = (end + 1) % size;
		data[end] = value;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(isEmpty()){
			return false;
		}
		if(start == end){
			start = -1;
			end = -1;
			return true;
		}
		start = (start + 1) % size;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if(isEmpty()){
			return -1;
		}
		return data[start];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if(isEmpty()){
			return -1;
		}
		return data[end];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return start == -1;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (end + 1) % size == start;
	}

/*  用链表的方法写的，太垃圾了
	private List<Integer> data;

	private int len;

	*//** Initialize your data structure here. Set the size of the queue to be k. *//*
	public MyCircularQueue(int k) {
		data = new ArrayList<>();
		this.len = k;
	}

	*//** Insert an element into the circular queue. Return true if the operation is successful. *//*
	public boolean enQueue(int value) {
		if(isFull()){
			return false;
		}
		data.add(value);
		return true;
	}

	*//** Delete an element from the circular queue. Return true if the operation is successful. *//*
	public boolean deQueue() {
		if(isEmpty()){
			return false;
		}
		if(data.size() == 1){
			data.remove(0);
			return true;
		}
		data = data.subList(1,data.size() - 1);
		return true;
	}

	*//** Get the front item from the queue. *//*
	public int Front() {
		if(isEmpty()){
			return -1;
		}
		return data.get(0);
	}

	*//** Get the last item from the queue. *//*
	public int Rear() {
		if(isEmpty()){
			return -1;
		}
		return data.get(data.size() - 1);
	}

	*//** Checks whether the circular queue is empty or not. *//*
	public boolean isEmpty() {
		if(data.size() == 0){
			return true;
		}
		return false;
	}

	*//** Checks whether the circular queue is full or not. *//*
	public boolean isFull() {
		if(data.size() == len){
			return true;
		}
		return false;
	}*/
}
