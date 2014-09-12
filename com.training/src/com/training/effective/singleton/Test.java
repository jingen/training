package com.training.effective.singleton;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "stringette";
		System.out.println(s);
		Case c = new Case();
		System.out.println(c.getName());
		System.out.println(c.getAge());
	}

}
