package com.training.first;

public class AtoI {
	
	public static int atoi(String aString){
		char[] chars = aString.toCharArray();
		int isPositive = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<chars.length; i++){
			if(Character.isDigit(chars[i]) || chars[i] == '-'){
				if(chars[i]!='-'){
					sb.append(chars[i]);
				}else if(sb.length()==0){
					isPositive = -1;
				}
			}
		}
		
		chars = sb.toString().toCharArray();
		int result = 0;
		if (chars.length > 10) {
			if(isPositive == 1) result = Integer.MAX_VALUE;
			else result = Integer.MIN_VALUE;
		}else{
			for(int i=chars.length-1, j=0; i>=0; i--, j++){
				int digit = Character.getNumericValue(chars[i]);
				int isOverflow = isOverflow(result, digit, isPositive);
				if(isOverflow == 0){
					result += digit*powerOf10(j);
				}else if(isOverflow == 1){
					result = Integer.MAX_VALUE;
					break;
				}else if(isOverflow == -1){
					result = Integer.MIN_VALUE;
					isPositive = 1;
					break;
				}
			}
		}
		result *= isPositive;
		System.out.println(result);
		return result;
	}
	
	private static int isOverflow(int number, int next, int isPositive){
		if(isPositive == 1){
			if(number > 147483647 && next > 1){
				return 1;
			}
		}else{
			if(number > 147483648 && next > 1){
				return -1;
			}
		}
		return 0;
	}

	private static int powerOf10(int n){
		int result = 1;
		for(int i=0; i<n; i++){
			result *= 10;
		}
		return result;
	}
	
	public static final int maxBase = Integer.MAX_VALUE/10;
	public static int atoi2(String aString){
		int i=0, n=aString.length();
		while(i<n && Character.isWhitespace(aString.charAt(i))) i++;
		int sign = 1;
		if(aString.charAt(i) == '+'){
			i++;
		}else if(aString.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		int result = 0;
		while(i<n && Character.isDigit(aString.charAt(i))){
			int next = Character.getNumericValue(aString.charAt(i));
			if(result > maxBase || result == maxBase && next > 7){
				return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result*10 + next;
			i++;
		}
		result *= sign;
		return result;
	}
	public static void main(String[] args){
//		int result = 0;
//		result = atoi("   -33 33f3sda;fljasldkjf");
//		result = atoi("2147483646");
//		result = atoi("-2147483649");
//		atoi("33");
		System.out.println(atoi2("-2147483649"));
	}
}
