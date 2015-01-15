package com.training.first;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {

	private List<Integer> steps = new ArrayList<Integer>(){
		private static final long serialVersionUID = 1L;
		{
			add(1);
			add(2);
		}
	};
	
	public int climbStairs(int n){
		if(n==1) return steps.get(0);
		if(n==2) return steps.get(1);
		if(n<=steps.size()) return steps.get(n-1);
		int result = climbStairs(n-1) + climbStairs(n-2);
        steps.add(result);
		return result;
	}
	
	public int climbStairs2(int n){
		int p=1, q=1;
		for(int i=2; i<=n; i++){
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
	
	public static void main(String[] args){
		ClimbingStairs cs = new ClimbingStairs();
		int result = cs.climbStairs(30);
		System.out.println(result);
		result = cs.climbStairs2(30);
		System.out.println(result);
	}
}
