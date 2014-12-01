package com.training.first;

import java.util.HashSet;
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
	}
}
