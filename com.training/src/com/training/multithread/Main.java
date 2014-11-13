package com.training.multithread;

public class Main {
	
	public static void main(String[] args){
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter, "syn");
		Thread threadB = new CounterThread(counter, "noSyn");
		
		threadA.start();
		threadB.start();
	}
}
