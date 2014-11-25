package com.training;

public class MultiParam {
	public static int sum(int...args){
		int result = 0;
		for(int arg: args){
			result += arg;
		}
		return result;
	}
	
	public static void main(String[] args){
//		System.out.println(sum(1,2,3));
//		System.out.println(Collections.emptyList().hashCode());
//		System.out.println(new ArrayList<String>().hashCode());
		Integer i = 42;
		Integer j = 42;
		if(i==j) System.out.println("OK");
	}
}
