package com.algorithm;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {

    final PriorityQueue<Integer> queue;
    
	final int k;
	
	public KthLargest(int k,int[] a){
		this.k = k;
		queue = new PriorityQueue<>(k);
		for(int n : a)
			add(n);
	}
	
	public int add(int n){
		if(queue.size() < k)
			queue.offer(n);
		else if (queue.peek() < n){
			queue.poll();
			queue.offer(n);
		}
		return queue.peek();
	}
	
	
	public static void main(String...strings){
		
		int[] array = new int[5];
		Random random = new Random();
		
		for(int i = 0;i < 5;i++){
			array[i] = random.nextInt(100);
			System.out.print(array[i] + " ");
		}
		
		KthLargest kthlargest = new KthLargest(2,array);
		
		System.out.println(kthlargest.queue);;
	}
}
