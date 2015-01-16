package com.training.first;

public class MaximumSumSubarray {

	public static int maxSumSubarray(int[] A){
		return maxSum(A, 0, A.length-1);
	}

	private static int maxSum(int[] A, int L, int R){
		if(L>R) return Integer.MIN_VALUE;
		int M = (L+R)/2;
		int left = maxSum(A, L, M-1);
		int right = maxSum(A, M+1, R);
		int sum = 0;
		int leftMax = 0, rightMax = 0;
		for(int i=M-1; i>=L; i--){
			sum += A[i];
			leftMax = Math.max(leftMax, sum);
		}
		sum = 0;
		for(int i=M+1; i<=R; i++){
			sum += A[i];
			rightMax = Math.max(rightMax, sum);
		}
		int max = leftMax + A[M] + rightMax;
		return Math.max(max, Math.max(left, right));
	}

	public static int maxSumSubarray2(int[] A){
		int maxEndingHere = A[0], maxSoFar = A[0];
		for(int i=0; i<A.length; i++){
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args){
		int[] A = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(maxSumSubarray(A));
		System.out.println(maxSumSubarray2(A));
	}
}
