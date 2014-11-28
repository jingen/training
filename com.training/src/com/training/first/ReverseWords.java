package com.training.first;

import java.util.LinkedList;
import java.util.List;

public class ReverseWords {

	public static String reverseWords(String aString){
		List<String> words = new LinkedList<String>();
		StringBuilder word = new StringBuilder();
		
		for(int i=0; i<aString.length(); i++){
//			if(aString.charAt(i) == ' '){
			if(isSpace(aString.charAt(i))){
				if(word.length()!=0){
					words.add(word.toString());
					word.setLength(0);
//					word = new StringBuilder();
				}
			}else{
				word.append(aString.charAt(i));
			}
			if(i==aString.length()-1 && word.length()!=0) words.add(word.toString());
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=words.size()-1; i>=0; i--){
			if(result.length()!=0) result.append(' ');
			result.append(words.get(i));
		}
		return result.toString();
	}
	
	public static String reverseWords2(String aString){
		int j = aString.length();
		StringBuilder result = new StringBuilder();
		for(int i=aString.length()-1; i>=0; i--){
			if(isSpace(aString.charAt(i))){
				j = i;
			}else{
				if(i==0||isSpace(aString.charAt(i-1))){
					if(result.length()!=0) result.append(' ');
					result.append(aString.substring(i, j));
//					if(i!=0)result.append(' ');
				}
			}
		}
		return result.toString();
	}
	
	public static void out(Object input){
		System.out.println(input);
	}
	public static boolean isSpace(char ch){
		return Character.isWhitespace(ch);
	}
	public static void main(String[] args){

		String aString = "I am a very   good 			man  "; // this string contains tab, new line
//		String aString = "I am a very   good            man"; // this string only contains space.
//		out(aString.charAt(1) == ' ');
		out(reverseWords(aString));
		out(reverseWords2(aString));
//		aString.charAt(aString.length());
	}
}
