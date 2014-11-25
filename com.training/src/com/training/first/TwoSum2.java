package com.training.first;
/**
 * The array is sorted.
 * @author Jingen Lin
 *
 */
public class TwoSum2 {
	public static final int NO_FOUND = -1;
	
	public static int binarySearch(int[] numbers, int key, int start, int end){
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
	
	public static int[] findSum(int[] numbers, int target){
		for(int i=0; i<numbers.length; i++){
			int result = binarySearch(numbers, target - numbers[i], i+1, numbers.length -1);
			if(result != NO_FOUND){
				return new int[] { i+1, result + 1};
			}
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static int[] findSum2(int[] numbers, int target){
		int i=0, j=numbers.length-1; 
		while(i<j){
			if(numbers[i] + numbers[j] == target){
				return new int[] { i+1, j+1 };
			}else if(numbers[i] + numbers[j] > target){
				j -= 1;
			}else{
				i += 1;
			}
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static void main(String[] args){
		int[] testArray = {1, 3, 7, 8, 9, 12, 13, 17};
//		int[] result = findSum(testArray, 17);
		int[] result = findSum2(testArray, 17);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
}
