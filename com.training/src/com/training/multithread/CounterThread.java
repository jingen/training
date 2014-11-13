package com.training.multithread;

public class CounterThread extends Thread {
	protected Counter counter = null;
	protected String option;

	public CounterThread(Counter counter, String option) {
		this.counter = counter;
		this.option = option;
	}

	public void run() {
		if ("syn".equals(option)) {
			for (int i = 0; i < 10; i++) {
				counter.add(i);
			}
		} else {
			for (int i = 1000; i<1010; i++){
				counter.addWithOutSyn(i);
			}
		}
	}
}
