package com.training.first;

public class ValidNumber {
	
	public static boolean isValidNumber(String aString){
//		aString = aString.trim();
		int i=0, start, end;
		while(i<aString.length() && Character.isWhitespace(aString.charAt(i))) i++;
		if(aString.charAt(i)=='+' || aString.charAt(i)=='-') i++;
		start = i;
		i = aString.length() - 1;
		while(i>=0 && Character.isWhitespace(aString.charAt(i))) i--;
		end = i+1;
		if(start < end){
			aString = aString.substring(start, end);
		}else{
			return false;
		}

		boolean hasDecimalPoint = false;
		for(i=0; i<aString.length(); i++){
			if(!Character.isDigit(aString.charAt(i))){
				if(aString.charAt(i)=='.' && !hasDecimalPoint) {
					hasDecimalPoint = true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(isValidNumber("0.1"));
	}
}
