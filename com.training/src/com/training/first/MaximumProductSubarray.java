package com.training.first;

public class MaximumProductSubarray {
	public static int maxProductSubarray(int[] A){
		int max=A[0], min=A[0], maxProduct=A[0];
		for(int i=1; i<A.length; i++){
			int mx=max, mn=min;
			max = Math.max(Math.max(mx*A[i], A[i]), mn*A[i]);
			min = Math.min(Math.min(mx*A[i], A[i]), mn*A[i]);
			maxProduct = Math.max(maxProduct, max);
		}
		return maxProduct;
	}
	
	public static void main(String[] args){
		int[] A = {2,3,-2,4};
		System.out.println(maxProductSubarray(A));
	}
}
