package com.training.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	private static final Map<Character, Character> parentheses = new HashMap<Character, Character>() {

		private static final long serialVersionUID = 1L;

		{
			put('(', ')');
			put('[', ']');
			put('{', '}');
		}
	};

	public boolean isValid(String s){
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()){
			if(parentheses.containsKey(c)){
				stack.push(c);
			}else{
				if(stack.isEmpty() || parentheses.get(stack.pop()) != c) return false;
			}
		}
		return stack.isEmpty();
	}
}
