package com.training.first;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/**
	 * Mine Brute Force
	 * @param intArray
	 * @param target
	 * @return
	 */
	public static int[] getIndices(int[] intArray, int target){
		int[] result = new int[2];
//		twoSumLoop:
		for(int i=0; i<intArray.length; i++){
			for(int j=i+1; j<intArray.length; j++){
				if(intArray[i] + intArray[j] == target){
					result[0] = i+1;
					result[1] = j+1;
//					break twoSumLoop;
					return result;
				}
			}
		}
		throw new IllegalArgumentException("No Matches");
//		return result;
	}
	
	public static int[] getIndices2(int[] intArray, int target){
		int[] result = new int[2];
		Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
		for(int i=0;i<intArray.length; i++){
			valueToIndex.put(intArray[i], i);
		}
		for(int i=0;i<intArray.length; i++){
			if(valueToIndex.containsKey(target-intArray[i])){
				result[0] = i+1;
				result[1] = valueToIndex.get(target-intArray[i]) + 1;
				return result;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] getIndices3(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++){
			int x = numbers[i];
			if(map.containsKey(target-x)){
				return new int[]{map.get(target - x) + 1, i+1};
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("There is no solution for two sum.");
		
	}
	
	public static void main (String[] args){
		int[] testArray = {3,7,8,2,1};
		int target = 8;
//		int[] result = getIndices(testArray, target);
//		int[] result = getIndices2(testArray, target);
		int[] result = getIndices3(testArray, target);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
