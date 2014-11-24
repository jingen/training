package com.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest implements Comparable<ComparableTest>{
//public class ComparableTest {
	public int myNumber;
	ComparableTest(int num){
		this.myNumber = num;
	}
	
	@Override
	public int compareTo(ComparableTest o){
		return this.myNumber - o.myNumber;
	}
	
	@Override
	public String toString(){
		return "Number:"+myNumber;
	}
//	@SuppressWarnings("unchecked")
	
//	public class IntComparator implements Comparator<ComparableTest> {
//
//		@Override
//		public int compare(ComparableTest arg0, ComparableTest arg1) {
//			return arg0.myNumber - arg1.myNumber;
//		}
//		
//	}
	public static void main(String[] args){
		List<ComparableTest> list = new ArrayList<ComparableTest>();
		list.add(new ComparableTest(7));
		list.add(new ComparableTest(3));
		list.add(new ComparableTest(5));
//		Collections.sort(list);
		Collections.sort(list, new Comparator<ComparableTest>(){
			@Override
			public int compare(ComparableTest arg0, ComparableTest arg1){
				return (arg1.myNumber - arg0.myNumber);
			}
		});
		System.out.println(list);
		
		
	}

}
