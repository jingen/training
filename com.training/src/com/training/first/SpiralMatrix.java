package com.training.first;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> elements = new ArrayList<Integer>();
		if(matrix.length==0) return elements;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		while(true){
			for(int i=0; i<n; i++){
				elements.add(matrix[row][++col]);
			}
			if(--m==0)break;
			for(int i=0; i<m; i++){
				elements.add(matrix[++row][col]);
			}
			if(--n==0)break;
			for(int i=0; i<n; i++){
				elements.add(matrix[row][--col]);
			}
			if(--m==0)break;
			for(int i=0; i<m; i++){
				elements.add(matrix[--row][col]);
			}
			if(--n==0)break;
		}
		return elements;
	}
	
	public static void main(String[] args){
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result);
	}
}
