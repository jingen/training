package com.training.multithread;

public class Counter {
	long count = 0;
	
	public synchronized void add(long value){
		this.count += value;
		System.out.println(this.count);
	}
	public synchronized void addWithOutSyn(long value){
		this.count += value;
		System.out.println(this.count);
	}
}
