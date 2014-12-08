package com.training.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

	public static void plusOne(List<Integer> number){
		for(int i=number.size()-1; i>=0; i--){
			int digit = number.get(i);
			if(digit < 9){
				number.set(i, digit+1);
				return;
			}else{
				number.set(i, 0);
			}
		}
		number.add(0);
		number.set(0, 1);
	}
	
	public static int[] plusOne2(int[] digits){
		for(int i=digits.length-1; i>=0; i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}else{
				digits[i]=0;
			}
		}
		//increase the places of the digits
		digits = Arrays.copyOf(digits, digits.length+1);
		digits[0] = 1;
		return digits;
	}
	public static void main(String[] args){
//		Integer[] testArray = new Integer[]{9,9,9};
//		Integer[] testArray = new Integer[]{9,8,9};
//		Integer[] testArray = new Integer[]{1,9,9};
		Integer[] testArray = new Integer[]{1,2,3};
		List<Integer> number = new ArrayList<Integer>(Arrays.asList(testArray));

		plusOne(number);
		System.out.println(number);

		int[] testArray2 = new int[]{9,9,9};
		testArray2 = plusOne2(testArray2);
		System.out.println(Arrays.toString(testArray2));
	}
}
