package com.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		
		StackQueue sq = new StackQueue();
		//堆栈实现队列
		System.out.println("向队列中添加1,2,3,4");
		sq.queuePush(1);
		sq.queuePush(2);
		sq.queuePush(3);
		sq.queuePush(4);
		System.out.println("依次删除队列头部");
 
		for(int i = 0; i < 4; i++)
			System.out.println(sq.queuePop());
 
 
		//队列实现堆栈
		System.out.println("向堆栈中添加1,2,3,4");
		sq.stackPush(1);
		sq.stackPush(2);
		sq.stackPush(3);
		sq.stackPush(4);
		System.out.println("依次删除栈顶元素");
		for(int i = 0; i < 4; i++)
			System.out.println(sq.stackPop());
 
		//测试队列性能
		//依次输出190,100,200
		sq.queuePush(190);
		sq.queuePush(100);
		System.out.println(sq.queuePop());
		sq.queuePush(200);
		System.out.println(sq.queuePop());
		System.out.println(sq.queuePop());
 
	}
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
 
	Queue<Integer> queue1 = new ArrayDeque<Integer>();
	Queue<Integer> queue2 = new ArrayDeque<Integer>();
 
	//堆栈实现队列添加元素
	public void queuePush(int node){
		stack1.push(node);
	}
 
	//堆栈实现队列删除头部元素
	public int queuePop(){
		//如果两堆栈都是空的，那么抛出异常
		if(stack1.empty() && stack2.empty())
			throw new RuntimeException("stack null!!");
 
		//如果stack2非空，直接pop即可
		if(!stack2.empty()){
			return stack2.pop();
		}
 
		//如果stack2空的，就将stack1元素pop然后push到stack2中，然后pop
		//如果stack1的元素只有一个，那么直接pop也可以
		if(stack1.size() == 1)
			return stack1.pop();
 
		while(!stack1.empty()){
			stack2.push(stack1.pop());
		}
 
		return stack2.pop();
	}
 
	//队列实现堆栈添加元素
	public void stackPush(int node){
		if(queue1.isEmpty() && queue2.isEmpty()){
			queue1.offer(node);
		}
		else if(!queue1.isEmpty()){
			queue1.offer(node);
		}
		else{
			queue2.offer(node);
		}
	}
 
	//队列实现堆栈删除栈顶元素
	public int stackPop(){
		//如果两个队列都是空的，那么抛出异常
		if(queue1.isEmpty() && queue2.isEmpty()){
			throw new RuntimeException("queue null!!");
		}
 
		//正常情况下应该最多有一个队列非空
		//如果queue1非空
		if(!queue1.isEmpty()){
			//如果队列长度是1，那么直接poll即可
			if(queue1.size() == 1)
				return queue1.poll();
 
			//将queue1中元素poll删除然后添加到queue2中，直到queue1元素个数是1，然后poll返回即可
			while(queue1.size() > 1){
				queue2.offer(queue1.poll());
			}
 
			return queue1.poll();
		}
 
		//如果queue2非空
		//如果queue2长度是1，那么抛出异常
		if(queue2.size() == 1)
			return queue2.poll();
 
		while(queue2.size() > 1){
			queue1.offer(queue2.poll());
		}
 
		return queue2.poll();
	}
}
