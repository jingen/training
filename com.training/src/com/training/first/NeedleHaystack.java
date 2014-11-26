package com.training.first;

public class NeedleHaystack {

	/**
	 * 
	 * @param aString
	 * @param subString
	 * @return
	 */
	public static int strstr(String aString, String subString){
		for(int i=0; ;i++){
			for(int j=0; ;j++){
				if(j==subString.length()) return i;
				if(i+j==aString.length()) return -1;
				if(aString.charAt(i+j) != subString.charAt(j)) break;
			}
		}
	}
	
	public static int strstr2(String aString, String subString){
		if("".equals(subString)) return 0;
		if("".equals(aString)) return -1;
		if(subString.length() > aString.length()) return -1;
		for(int i=0; i<=aString.length() - subString.length(); i++){
			for(int j=0; j<subString.length(); j++){
				if(aString.charAt(i+j) != subString.charAt(j)) break;
				if(j==subString.length()-1) return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(strstr("", "subString"));
		System.out.println(strstr2("", "subString"));
		System.out.println(strstr("aString", ""));
		System.out.println(strstr2("aString", ""));
		System.out.println(strstr("I'm very", "I'm very good"));
		System.out.println(strstr2("I'm very", "I'm very good"));
		System.out.println(strstr("OK, I'm very good", "I'm very"));
		System.out.println(strstr2("OK, I'm very good", "I'm very"));
		System.out.println(strstr("aaaba", "ba"));
		System.out.println(strstr2("aaaba", "ba"));
		System.out.println(strstr("mississippi", "issi"));
		System.out.println(strstr2("mississippi", "issi"));
	}
}
