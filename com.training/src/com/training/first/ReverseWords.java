package com.training.first;

import java.util.LinkedList;
import java.util.List;

public class ReverseWords {

	public static String reverseWords(String aString){
		List<String> words = new LinkedList<String>();
		StringBuilder word = new StringBuilder();
		for(int i=0; i<aString.length(); i++){
			if(aString.charAt(i)==' ' || i==aString.length()-1){
				words.add(word.toString());
				if(i<aString.length()-1){
					while(aString.charAt(i+1)!=' ')i++;
				}
			}else{
				word.append(aString.charAt(i));
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i=words.size()-1; i>=0; i--){
			result.append(words.get(i)).append(" ");
		}
		return result.toString();
	}
	
	public static void out(String input){
		System.out.println(input);
	}
	public static void main(String[] args){
		String aString = "I am a very   good 			man";
		out(reverseWords(aString));
//		aString.charAt(aString.length());
	}
}
