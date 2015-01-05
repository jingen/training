package com.training.first;

public class IntegerToRoman {

	private static final int[] values = {
		1000, 900, 500, 400,
		100, 90, 50, 40,
		10, 9, 5, 4,
		1
	};
	
	
	private static final String[] symbols = {
		"M", "CM", "D", "CD",
		"C", "XC", "L", "XL",
		"X", "IX", "V", "IV",
		"I"
	};
	
	public static String intToRoman(int num){
		StringBuilder roman = new StringBuilder();
		int i = 0;
		while(num>0){
			int k = num/values[i];
			for(int j=0; j<k; j++){
				roman.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		return roman.toString();
	}

	public static void main(String[] args){
		System.out.println(intToRoman(1));
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(44));
	}
}
