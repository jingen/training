package com.training.first;

public class SearchInsertionPosition {

	public static int getPosition(int[] A, int target){
		int L = 0, R = A.length-1;
		while(L<R){
			int M = (L+R)/2;
			if(A[M] > target){
				R = M-1;
			}else if(A[M] < target){
				L = M+1;
			}else{
				return M;
			}
		}
		return (A[L] > target)? L:L+1;
	}
	
	public static int searchInsert(int[] A, int target){
		int L=0, R=A.length-1;
		while(L<R){
			int M = (L+R)/2;
			if(A[M]<target){
				L = M+1;
			}else{
				R = M;
			}
		}
		return A[L] < target ? L+1:L;
	}
	
	public static void main(String[] args){
		int[] A = {1,3,5,6};
		System.out.println(getPosition(A, 5));
		System.out.println(getPosition(A, 2));
		System.out.println(getPosition(A, 7));
		System.out.println(getPosition(A, 0));
		System.out.println(searchInsert(A, 5));
		System.out.println(searchInsert(A, 2));
		System.out.println(searchInsert(A, 7));
		System.out.println(searchInsert(A, 0));
	}
}
