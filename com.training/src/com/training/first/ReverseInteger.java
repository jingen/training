package com.training.first;

public class ReverseInteger {

	public static final int BOUNDARY = Integer.MAX_VALUE/10;
	public static int reverse(int aInt){
		int result=0;
//		while(aInt>0){ -- have to consider negative numbers
		while(aInt!=0){
			if(Math.abs(result) > BOUNDARY) return 0;
			result = result*10 + aInt%10;
			aInt = aInt/10;
		}
		return result;
	}
	
	public static void main(String[] args){
		int x = 1230;
		System.out.println(reverse(x));
		x = -1230;
		System.out.println(reverse(x));
		System.out.println(reverse(Integer.MAX_VALUE));
	}
}
