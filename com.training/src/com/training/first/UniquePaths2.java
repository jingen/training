package com.training.first;

public class UniquePaths2 {

	public static int uniquePaths(int[][] obstacle){
		int m = obstacle.length;
		int n = obstacle[0].length;
		int[][] matrix = new int[m+1][n+1];
		
		for(int row=m-1;row>=0;row--){
			for(int col=n-1;col>=0;col--){
				if(obstacle[row][col]==1) {
					matrix[row][col] = 0;
				}else{
					matrix[row][col] = (row==m-1 && col==n-1)? 1:matrix[row+1][col]+matrix[row][col+1];
				}
			}
		}
		return matrix[0][0];
	}
	
	public static void main(String[] args){
		
		int[][] ob = new int[4][7];
		ob[2][6] = 1;
		int result = uniquePaths(ob);
		System.out.println(result);
	}
}
