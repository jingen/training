package com.training.first;

public class CoinsInALine {

	public static final int MAX_N = 100;
	public static void printMoves(int[][] P, int[] A, int N){
		int sum1 = 0, sum2 = 0;
		int m=0, n=N-1;
		boolean myTurn=true;
		while(m<=n){
			int P1=P[m+1][n];
			int P2=P[m][n-1];
			System.out.println((myTurn? "I": "You") + " take coin no. ");
		}
	}
	public static void main(String[] args){
		System.out.println("Coins in a Line.");
	}
}
