package com.training.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

	public static int findSingle(int[] numbers){
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(int number : numbers){
			if(table.containsKey(number)){
				table.put(number, table.get(number)+1);
			}else{
				table.put(number, 1);
			}
			// int count = table.containKey(number) ? table.get(number):0;
			// table.put(number, count+1);
		}
		
		for(int number : numbers){
			if(table.get(number)==1){
				return number;
			}
		}
		throw new IllegalArgumentException("There is no such Integer that appears exact once.");
	}
	
	public static int findSingle2(int[] numbers){
		Set<Integer> set = new HashSet<Integer>();
		for(int number: numbers){
			if(set.contains(number)){
				set.remove(number);
			}else{
				set.add(number);
			}
		}
		if(set.size()==0) throw new IllegalArgumentException("No such Integer is found.");
		return set.iterator().next();
	}
	
	public static int findSingle3(int[] numbers){
		int result = 0;
		for(int number: numbers){
			result ^= number;
		}
		return result;
	}
	
	public static void main(String[] args){
//		int[] numbers = {11, 2, 4, 5, 5, 4, 11};
//		System.out.println(findSingle(numbers));
		int[] numbers = {11, 2, 4, 5, 5, 4, 11};
		System.out.println(findSingle2(numbers));
		System.out.println(findSingle3(numbers));
	}
}
