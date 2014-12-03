package com.training.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringTD {
	private static final int UNKNOWN = -1;

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int i=0, j = UNKNOWN, longest=0;
		for(int k=1; k<s.length(); k++){
			if(s.charAt(k) == s.charAt(k-1)) continue;
			if(j!= UNKNOWN && s.charAt(j)!=s.charAt(k)){
				longest = Math.max(longest, k-i);
				i = j + 1;
			}
			j = k-1;
		}
		return Math.max(longest, s.length()-i);
	}
	public static int lengthOfLongestSubstringTwoDistinct3(String s){
		int[] count = new int[256];
		int i=0, numDistinct=0, maxLen=0;
		for(int j=0; j<s.length(); j++){
			if(count[s.charAt(j)]==0) numDistinct++;
			count[s.charAt(j)]++;
			while(numDistinct>2){
				count[s.charAt(i)]--;
				if(count[s.charAt(i)]==0) numDistinct--;
				i++;
			}
			maxLen=Math.max(j-i+1, maxLen);
		}
		return maxLen;
	}
	public static int lengthOfLongestSubstringTwoDistinct4(String s){
		Map<Character, Integer> occurrence = new HashMap<Character, Integer>();
		int i=0, numDistinct=0, longest=0;
		for(int j=0; j<s.length(); j++){
			if(occurrence.containsKey(s.charAt(j))){
				occurrence.put(s.charAt(j), occurrence.get(s.charAt(j))+1);
			}else{
				occurrence.put(s.charAt(j), 1);
				numDistinct++;
			}
			while(numDistinct>2){
				occurrence.put(s.charAt(i), occurrence.get(s.charAt(i))-1);
				if(occurrence.get(s.charAt(i))==0) numDistinct--;
				i++;
			}
			longest = Math.max(longest, j-i+1);
		}
		return longest;
	}
	public static int lengthOfLongestSubstringTwoDistinct2(String s) {
		int longest = 0;
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			charSet.clear();
			charSet.add(s.charAt(i));
			for (int j = i; j < s.length(); j++) {
				if (!charSet.contains(s.charAt(j))) {
					charSet.add(s.charAt(j));
				}
				if (charSet.size() < 3) {
					longest = Math.max(longest, j - i + 1);
				} else {
					break;
				}
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		String s = "ecebaxyzzzz";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
		System.out.println(lengthOfLongestSubstringTwoDistinct2(s));
		System.out.println(lengthOfLongestSubstringTwoDistinct3(s));
		System.out.println(lengthOfLongestSubstringTwoDistinct4(s));
	}
}
