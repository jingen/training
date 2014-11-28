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
		boolean isNumeric = false;
		for(i=0; i<aString.length(); i++){
			if(!Character.isDigit(aString.charAt(i))){
				if(aString.charAt(i)=='.' && !hasDecimalPoint) {
					hasDecimalPoint = true;
				}else{
					return false;
				}
			}else{
				isNumeric = true;
			}
		}
		return isNumeric;
	}
	
	public static boolean isValidNumber2(String aString){
		int i=0, n=aString.length();
		while(i<n&&Character.isWhitespace(aString.charAt(i))) i++;
		if(i<n&&(aString.charAt(i)=='+'||aString.charAt(i)=='-')) i++;
		boolean isNumeric = false;
		while(i<n && Character.isDigit(aString.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if(i<n && aString.charAt(i)=='.'){
			i++;
			while(i<n && Character.isDigit(aString.charAt(i))){
				i++;
				isNumeric = true;
			}
		}
		/**
		 * If the number contains an optional exponent part.
		 */
		if(isNumeric&&i<n&&aString.charAt(i)=='e'){
			i++;
			isNumeric = false;
			if(i<n&&(aString.charAt(i)=='+'||aString.charAt(i)=='-')) i++;
			while(i<n&&Character.isDigit(aString.charAt(i))){
				i++;
				isNumeric = true;
			}
		}
		while(i<n&&Character.isWhitespace(aString.charAt(i))) i++;
		return isNumeric && i==n;
	}

	public static void main(String[] args){
//		System.out.println(isValidNumber("0.1"));
//		System.out.println(isValidNumber2("0.1"));
//		System.out.println(isValidNumber("0.."));
//		System.out.println(isValidNumber2("0.."));
//		System.out.println(isValidNumber("0"));
//		System.out.println(isValidNumber2("0"));
		System.out.println(isValidNumber2("30e-1"));
		System.out.println(isValidNumber2("30e-33"));
		System.out.println(isValidNumber2("30e"));
		System.out.println(isValidNumber2("30e1"));
		System.out.println(isValidNumber2("30e10"));
		System.out.println(isValidNumber2("e0"));
	}
}
