package com.training.first;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum3 {
	
	private List<Integer> numbers = new LinkedList<Integer>();
	private Map<Integer, int[]> table = new HashMap<Integer, int[]>();
	
	private Map<Integer, Integer> table2 = new HashMap<Integer, Integer>();

	public void add(int value){
		for(int i=0; i<numbers.size(); i++){
			int sum = value + numbers.get(i);
			if(!table.containsKey(sum)){
				table.put(sum, new int[]{i+1, numbers.size()+1});
			}
		}
		numbers.add(value);
	}
	
	public void add2(int value){
		if(table2.containsKey(value)){
			int count = table2.get(value) + 1;
			table2.put(value, count);
		}else{
			table2.put(value, 1);
		}
	}

	public boolean find(int value){
		return table.containsKey(value);
	}
	
	public boolean find2(int value){
		int difference;
		for(Entry<Integer, Integer> entry : table2.entrySet()){
			difference = value - entry.getKey();
			if(difference == entry.getKey() && entry.getValue() > 2){
				return true;
			}else if(table2.containsKey(difference)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		TwoSum3 myTest = new TwoSum3();
//		myTest.add(1);
//		myTest.add(3);
//		myTest.add(5);
//		System.out.println(myTest.find(4));
//		System.out.println(myTest.find(7));
		myTest.add2(1);
		myTest.add2(3);
		myTest.add2(5);
		System.out.println(myTest.find2(4));
		System.out.println(myTest.find2(7));
	}
}
