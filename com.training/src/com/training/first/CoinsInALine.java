package com.training.first;

public class CoinsInALine {

	public static final int MAX_N = 100;
	public static void printMoves(int[][] P, int[] A, int N){
//		int sum1 = 0, sum2 = 0;
		int m=0, n=N-1;
		boolean myTurn=true;
		while(m<=n){
			int P1=P[m+1][n];
			int P2=P[m][n-1];
			System.out.print((myTurn? "I": "You") + " take coin no. ");
			if(P1<=P2){
				System.out.print(m+1+"("+A[m]+")");
				m++;
			}else{
				System.out.print(n+1+"("+A[n]+")");
				n--;
			}
			System.out.println(myTurn? ", ":".");
			myTurn = !myTurn;
		}
		System.out.println("The total amount of money (maximum) I get is " + P[0][N-1] + ".");
	}
	
	public static int maxMoney(int A[], int N){
		int P[][] = new int[MAX_N][MAX_N];
		int a, b, c;
		for(int i=0; i<N; i++){
			for(int m=0, n=i; n<N; m++, n++){
				assert(m<N); assert(n<N);
				a = ((m+2<=N-1)? P[m+2][n]:0);
				b = ((m+1<=N-1 && n-1 >=0)? P[m+1][n-1]:0);
				c = ((n-2>=0)? P[m][n-2]:0);
				P[m][n] = Math.max(A[m] + Math.min(a,b), A[n]+Math.min(b,c));
			}
		}
		printMoves(P,A,N);
		return P[0][N-1];
	}

	public static int P(int[] A, int start, int end){
		if(start>end) return 0;
		int p1 = A[start] + Math.min(P(A, start+2, end), P(A, start+1, end-1));
		int p2 = A[end] + Math.min(P(A, start+1, end-1), P(A, start, end-2));
		return Math.max(p1, p2);
	}
	public static void main(String[] args){
		System.out.println("Coins in a Line.");
		int[] A = {3,2,2,3,1,2};
//		maxMoney(A, 6);
		System.out.println(P(A, 0, A.length-1));
	}
}
