package com.training.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	private static final Set<String> OPERATORS = new HashSet<String>(
			Arrays.asList("+", "-", "*", "/"));

	private int eval(int x, int y, String op) {
		switch (op) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		case "/":
			return x / y;
		default:
			throw new IllegalArgumentException("Operator is not correct!");
		}
	}
	
	public int evalRPN(String[] tokens){
		Stack<Integer> stack = new Stack<Integer>();
		for(String token:tokens){
			if(OPERATORS.contains(token)){
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			}else{
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
	
//	approach 2
	interface Operator{
		int eval(int x, int y);
	}
	
	private static final Map<String, Operator> Operators = new HashMap<String, Operator>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("+", new Operator(){
				public int eval(int x, int y){return x+y;}
			});
			put("-", new Operator(){
				public int eval(int x, int y){return x-y;}
			});
			put("*", new Operator(){
				public int eval(int x, int y){return x*y;}
			});
			put("/", new Operator(){
				public int eval(int x, int y){return x/y;}
			});
		}
	};
	
	public int evalRPN2(String[] tokens){
		Stack<Integer> stack = new Stack<Integer>();
		for(String token: tokens){
			if(Operators.containsKey(token)){
				int y = stack.pop();
				int x = stack.pop();
				stack.push(Operators.get(token).eval(x, y));
			}else{
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args){
		String[] tokens1 = {"8", "1", "2", "+", "2", "*", "-"};
		String[] tokens2 = {"10", "8", "1", "2", "+", "2", "*", "-", "/"};
		EvaluateReversePolishNotation t = new EvaluateReversePolishNotation();
		System.out.println(t.evalRPN(tokens1));
		System.out.println(t.evalRPN2(tokens1));
		System.out.println(t.evalRPN(tokens2));
		System.out.println(t.evalRPN2(tokens2));
	}
}
