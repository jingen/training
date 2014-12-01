package com.training.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWR {
	
	public static int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i=0,longest=0;
		for(int j=0; j<s.length(); j++){
			//move i right after the position the character occurs for the first time
			while(exist[s.charAt(j)]){
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			longest = Math.max(longest, j-i+1);
		}
		return longest;
	}
	
	public static int lengthOfLongestSubstring2(String s){
		Set<Character> characters = new HashSet<Character>();
		int i=0, longest=0;
		for(int j=0; j<s.length(); j++){
			while(characters.contains(s.charAt(j))){
				characters.remove(s.charAt(i));
				i++;
			}
			characters.add(s.charAt(j));
			longest = Math.max(longest, j-i+1);
		}
		return longest;
	}
	
	public static int lengthOfLongestSubstring3(String s){
		int[] table = new int[256];
		Arrays.fill(table, -1);
		int i=0, longest=0;
		for(int j=0; j<s.length(); j++){
			if(table[s.charAt(j)]>=i){
				i = table[s.charAt(j)] + 1;
			}
			table[s.charAt(j)] = j;
			longest = Math.max(longest, j-i+1);
		}
		return longest;
		
	}
	public static int lengthOfLongestSubstring4(String s){
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		int i=0, longest=0;
		for(int j=0; j<s.length(); j++){
			if(table.containsKey(s.charAt(j)) && table.get(s.charAt(j))>=i){
				i = table.get(s.charAt(j)) + 1;
			}
			table.put(s.charAt(j), j);
			longest = Math.max(longest, j-i+1);
		}
		return longest;
	}

	public static void main(String[] args){
		int number;
		String aString = "xyzabcdefb12345bc67890-=";
		number = lengthOfLongestSubstring(aString);
		System.out.println(number);
		number = lengthOfLongestSubstring2(aString);
		System.out.println(number);
		number = lengthOfLongestSubstring3(aString);
		System.out.println(number);
		number = lengthOfLongestSubstring4(aString);
		System.out.println(number);
	}
}
