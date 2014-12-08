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
	
	public static boolean isPanlindrome2(int number){
		int div = 1;
		while(number/div>=10){
			div *= 10;
		}
		while(number>=10){
			int head = number/div;
			int tail = number%10;
			if(head!=tail) return false;
			number = number%div/10;
			div /= 100;
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(isPanlindrome(9361));
		System.out.println(isPanlindrome2(9361));
		System.out.println(isPanlindrome(1639361));
		System.out.println(isPanlindrome2(1639361));
//		reverse(-33);
		System.out.println(isPanlindrome(Integer.MAX_VALUE));
		System.out.println(isPanlindrome2(Integer.MAX_VALUE));
		System.out.println(isPanlindrome2(89733798));
	}
}
