package com.ligz.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ligz
 */
public class MyQueue {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		System.out.println(queue.peek());
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.poll();
		System.out.println(queue.peek());
		System.out.println(queue.size());
	}
}
