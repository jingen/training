package com.training.first;

public class TwoSum2 {
	private static final int NO_FOUND = -1;
	
	private static int binarySearch(int[] numbers, int key, int start, int end){
		while(start<=end){
			int middle = start + (end-start)/2;
			if(numbers[middle] == key){
				return middle;
			}else if(numbers[middle] < key){
				start = middle+1;
			}else{
				end = middle-1;
			}
		}
		return NO_FOUND;
	}
	
	private static int[] findSum(int[] numbers, int target){
		for(int i=0; i<numbers.length; i++){
			int result = binarySearch(numbers, target - numbers[i], 0, numbers.length -1);
			if(result != NO_FOUND){
				return new int[] { i+1, result + 1};
			}
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static void main(String[] args){
		int[] testArray = {1, 3, 7, 8, 9, 12, 13, 17};
		int[] result = findSum(testArray, 17);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println("End");
//		int result = binarySearch(testArray, 12, 0, testArray.length-1);
//		System.out.println(result);
		
	}
}
