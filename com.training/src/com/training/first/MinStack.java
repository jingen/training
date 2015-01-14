package com.training.first;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(Integer x){
		stack.push(x);
		if(minStack.isEmpty()||minStack.peek()>=x){
			minStack.push(x);
		}
	}
	
	public Integer pop(){
		int result = stack.pop();
		if(minStack.peek()==result){
			minStack.pop();
		}
		return result;
	}
	
	public Integer top(){
		return stack.peek();
	}
	
	public Integer getMin(){
		return minStack.peek();
	}
}
