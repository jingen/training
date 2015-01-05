package com.training.first;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	private static Map<Character, Integer> table = new HashMap<Character, Integer>() {

		private static final long serialVersionUID = 1L;
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};
	
	public static int romanToInt(String roman){
		int prev=0, total=0;
		for(Character c: roman.toCharArray()){
			int curr = table.get(c);
			total += (curr>prev)?(curr-2*prev):curr;
			prev = curr;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("XLIV"));
		System.out.println(romanToInt("I"));
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("V"));
		System.out.println(romanToInt("VI"));
	}
}
