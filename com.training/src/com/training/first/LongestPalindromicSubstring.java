package com.training.first;

public class LongestPalindromicSubstring {

	public static final int UNKNOWN = -1;
	public static boolean isPalindrome(String s){
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	public static String findLongestPalindrome(String s){
		int longest = UNKNOWN; String resultString = "";
		for(int i=0; i<s.length()-1; i++){
			for(int j=i+1; j<=s.length(); j++){
				if(j-i>longest && isPalindrome(s.substring(i, j))){
					longest = j-i;
					resultString = s.substring(i, j);
				}
			}
		}
		return resultString;
	}

	public static String findLongestPalindrome2(String s){
		int start=0, end=0;
		for(int i=0; i<s.length(); i++){
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len > end-start){
				start = i - (len-1)/2;
				end = i + (len)/2;
			}
		}
		return s.substring(start, end+1);
	}
	
	public static int expandAroundCenter(String s, int start, int end){
		int L = start, R = end;
		while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
			L--;
			R++;
		}
		return R-L-1;
	}
	public static void main(String[] args){
		String s = "caba";
//		System.out.println(isPalindrome(s));
//		s = "aba";
//		System.out.println(isPalindrome(s));
//		s = "aa";
//		System.out.println(isPalindrome(s));
//		s = "abcdcba";
//		System.out.println(isPalindrome(s));

		System.out.println(findLongestPalindrome(s));
		System.out.println(findLongestPalindrome2(s));
		s = "abacdfgdcaba";
		System.out.println(findLongestPalindrome(s));
		System.out.println(findLongestPalindrome2(s));
		s = "cacabacdgdcaba";
		System.out.println(findLongestPalindrome(s));
		System.out.println(findLongestPalindrome2(s));
	}
}
