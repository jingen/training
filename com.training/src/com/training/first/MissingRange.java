package com.training.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MissingRange {
	public static String[] getMissingRange(int[] elements){
		List<String> ranges = new LinkedList<String>();
		int difference;
		Integer element;
		for(int i=1; i<elements.length; i++){
			difference = elements[i] - elements[i-1];
			if(difference == 2){
				element = elements[i-1] + 1;
				ranges.add(element.toString());
			}else if(difference > 2){
				ranges.add((elements[i-1]+1) + "->" + (elements[i]-1));
			}
		}
		difference = 99 - elements[elements.length-1];
		if(difference == 1){
			ranges.add(new Integer(99).toString());
		}else if(difference > 2){
			ranges.add((elements[elements.length-1]+1) + "->" + 99);
		}
		
		return ranges.toArray(new String[ranges.size()]);
	}
	
	public static List<String> getMissingRange(int[] elements, int start, int end){
		List<String> ranges = new ArrayList<String>();
		int previous = start - 1;
		int current;
		for(int i=0; i<=elements.length; i++){
			if(i==elements.length){
				current = end + 1;
			}else{
				current = elements[i];
			}
			if(current - previous >= 2){
				ranges.add(generateRange(previous+1, current-1));
			}
			previous = current;
		}
		return ranges;
	}
	
	public static String generateRange(int from, int to){
		if(from == to){
			return String.valueOf(from);
		}else{
			return from + "->" + to;
		}
	}
	
	public static void main (String[] args){
		int[] test = {0,1,3,50,75};
//		[Ò2Ó, Ò4->49Ó, Ò51->74Ó, Ò76->99Ó]
		for(String s: getMissingRange(test)){
			System.out.println(s);
		}
		for(String s: getMissingRange(test, 1, 333)){
			System.out.println(s);
		}
	}
}