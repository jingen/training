package com.training.first;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

	public static int findSingle(int[] numbers){
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(int number: numbers){
			int count = table.containsKey(number)? table.get(number):0;
			table.put(number, count+1);
		}
		for(int number: numbers){
			if(table.get(number) == 1) return number;
		}
		throw new IllegalArgumentException("There is no such Integer that appears exact once.");
	}
	
	public static int findSingle2(int[] numbers){
		int[] count = new int[32];
//		Arrays.fill(count, 0);
		int result = 0;
		for(int i=0; i<32; i++){
			for(int j=0; j<numbers.length; j++){
				if(((numbers[j]>>i) & 1) != 0){
					count[i]++;
				}
			}
			result |= (count[i]%3) << i;
		}
		return result;
	}
	
	public static int findSingle3(int[] numbers){
		int ones = 0, twos = 0, threes = 0;
		for(int i=0; i<numbers.length; i++){
			twos |= ones & numbers[i];
			ones ^= numbers[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
	
	public int singleNumber(int[] A) {
        if (A == null) return 0;
        int x0 = ~0, x1 = 0, x2 = 0, t;
        for (int i = 0; i < A.length; i++) {
            t = x2;
            x2 = (x1 & A[i]) | (x2 & ~A[i]);
            x1 = (x0 & A[i]) | (x1 & ~A[i]);
            x0 = (t & A[i]) | (x0 & ~A[i]);
        }
        return x1;
    }
	public static void main(String[] args){
		int[] numbers = {11, 2, 4, 5, 4, 11, 11, 2, 2, 4};
		System.out.println(findSingle(numbers));
		System.out.println(findSingle2(numbers));
		System.out.println(findSingle3(numbers));
	}
}
