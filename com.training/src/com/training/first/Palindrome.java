package com.training.first;

public class Palindrome {

	public static boolean isPalindrome(String aString){
		String patter = "[^a-zA-Z0-9]";
		aString = aString.replaceAll(patter, "").toLowerCase();
		char[] chars = aString.toCharArray();
		for(int i=0, j=chars.length-1; i<j; i++,j--){
			if(chars[i] != chars[j]) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome2(String aString){
		char[] chars = aString.toCharArray();
		for(int i=0, j=chars.length-1; i<j; i++,j--){
			while(i<j && !Character.isLetterOrDigit(chars[i])){
				i++;
			}
			while(i<j && !Character.isLetterOrDigit(chars[j])){
				j--;
			}
			if(Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome3(String aString){
		int i = 0, j=aString.length()-1;
		while(i<j){
			while(i<j && !Character.isLetterOrDigit(aString.charAt(i))) i++;
			while(i<j && !Character.isLetterOrDigit(aString.charAt(j))) j--;
			if(Character.toLowerCase(aString.charAt(i)) != Character.toLowerCase(aString.charAt(j))) return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args){
		String str1 = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
//		System.out.println(isPalindrome(str1));
//		System.out.println(isPalindrome(str2));
//		System.out.println(isPalindrome2(str1));
//		System.out.println(isPalindrome2(str2));
		System.out.println(isPalindrome3(str1));
		System.out.println(isPalindrome3(str2));
	}
}
