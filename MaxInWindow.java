package com.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxInWindow {
	
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
		if (num == null || num.length < size || size == 0) {
			return result;
		}
		
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < num.length; i++) {
        	
        	if (!deque.isEmpty() && (i - deque.peekFirst()) == size) {
        		deque.pollFirst();// 如果队列头部的元素已经超出滑动窗口的范围，就将头部元素退出
        	}
        	
        	while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
        		deque.pollLast();// 如果新来的元素比队列最后一个元素大，则将最后一个元素退出
        	}
        	
        	deque.offer(i);
        	
        	if (i >= (size - 1)) {
        		result.add(num[deque.peekFirst()]);// 如果遍历的元素已经达到一个滑动窗口的大小，就开始提取窗口的最大值了
        	}
        	
        }
        
        return result;
    }
    
}