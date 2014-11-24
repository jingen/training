package com.training;

import java.util.Arrays;
import java.util.List;

public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		// ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new RuntimeException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		List<String> strings = Arrays.asList("shit", "shit1", "shit2");
		for(String string : strings ){
			stack.push(string);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().toUpperCase());
		}
	}

	private boolean isEmpty() {
		return size==0;
	}
}
