package com.training.first;

import java.util.Arrays;

public class UniquePaths {

	// the runtime complexity is m+n C m (m+n choose m)
	// the space complexity is O(m+n)
	private int backtrack(int r, int c, int m, int n){
		if(r==m-1&&c==n-1) return 1;
		if(r>=m||c>=n) return 0;
		return backtrack(r+1, c, m, n) + backtrack(r, c+1, m, n);
	}
	
	public int uniquePaths(int m, int n){
		return backtrack(0, 0, m, n);
	}
	
	// Memoization
	
	private int backtrack(int r, int c, int m, int n, int[][] matrix){
		if(r==m-1 && c==n-1) return 1;
		if(r>=m || c>=n) return 0; 
		if(matrix[r+1][c]==-1) matrix[r+1][c] = backtrack(r+1, c, m, n, matrix);
		if(matrix[r][c+1]==-1) matrix[r][c+1] = backtrack(r, c+1, m, n, matrix);

		return matrix[r+1][c] + matrix[r][c+1];
	}
	public int uniquePaths2(int m, int n){
		int[][] matrix = new int[m+1][n+1];
		for(int i=0; i<matrix.length; i++) Arrays.fill(matrix[i], -1);
		return backtrack(0, 0, m, n, matrix);
	}
	
	public int uniquePaths3(int m, int n){
		int[][] matrix = new int[m+1][n+1];
		for(int i = m-1; i>=0; i--){
			for(int j = n-1; j>=0; j--){
				matrix[i][j] = (i==m-1 && j==n-1)? 1: matrix[i+1][j] + matrix[i][j+1];
			}
		}
		return matrix[0][0];
	}
	public static void main(String[] args){
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(4, 7));
		System.out.println(up.uniquePaths2(4, 7));
		System.out.println(up.uniquePaths3(4, 7));
	}
}
