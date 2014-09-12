package com.training.effective.singleton;

public class Main {
	public static void main(String[] args){
		Elvis elvis1 = Elvis.getInstance();
		Elvis elvis2 = Elvis.getInstance();
		
		elvis1.leaveTheBuilding();
		elvis2.leaveTheBuilding();
	}
}
