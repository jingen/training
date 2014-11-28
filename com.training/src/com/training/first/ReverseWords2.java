package com.training.first;

public class ReverseWords2 {
	public static void reverse(char[] chars, int start, int end){
		for(int i=start, j=end-1; i<j; i++, j--){
			char tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}
	}
	/**
	 * @param chars
	 * @param begin
	 * @param end
	 */
	public static void reverse2(char[] chars, int begin, int end){
		for(int i=0; i<(end-begin)/2; i++){
			char tmp = chars[begin+i];
			chars[begin+i] = chars[end-i-1];
			chars[end-i-1] = tmp;
		}
	}
	
	public static void reverseWords(char[] chars){
		reverse(chars, 0, chars.length);
		for(int i=0,j=0; j<=chars.length; j++){
			if(j==chars.length||chars[j]==' '){
				reverse(chars, i, j);
				i=j+1;
			}
		}
	}
	
	public static void main(String[] args){
		String aString = "man good very a am I";
		char[] chars = aString.toCharArray();
		reverseWords(chars);
		System.out.print(chars);

	}
}
