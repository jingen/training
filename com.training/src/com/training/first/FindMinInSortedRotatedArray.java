package com.training.first;

public class FindMinInSortedRotatedArray {

	public int find(int[] A){
		int L=0, R=A.length-1;
		while(L<R && A[L]>A[R]){
			int M = (L+R)/2;
			if(A[M] > A[R]){
				L = M + 1;
			}else{
				R = M;
			}
		}
		return A[L];
	}
	
	public int find2(int[] A){
		int L=0, R=A.length-1;
		while(L<R && A[L]>=A[R]){
			int M = (L+R)/2;
			if(A[M]>A[R]){
				L = M+1;
			}else if(A[M]<A[R]){
				R = M;
			}else{
				L = L+1;
			}
		}
		return A[L];
	}

	public static void main(String[] args){
		int[] A = {5, 6, 7, 0, 1, 2, 3, 4};
		int[] B = {4, 5, 6, 7, 0, 1, 2};
		FindMinInSortedRotatedArray f = new FindMinInSortedRotatedArray();
		System.out.println(f.find(A));
		System.out.println(f.find(B));
	}
}
