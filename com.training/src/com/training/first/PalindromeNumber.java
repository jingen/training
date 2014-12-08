package com.training.first;

public class PalindromeNumber {
	
	public static int reverse(int number){
		assert number>=0;
		int result=0;
		while(number!=0){
			result = result*10 + number%10;
			number = number/10;
		}
		return result;
	}
	
	public static boolean isPanlindrome(int number){
		int reversedNumber = reverse(number);
		return reversedNumber == number;
	}
	public static void main(String[] args){
//		System.out.println(isPanlindrome(9361));
//		System.out.println(isPanlindrome(1639361));
//		reverse(-33);
		System.out.println(isPanlindrome(Integer.MAX_VALUE));
	}
}
