package com.training.effective.singleton;

public class Case {
	private final static Integer age;
	private final static String name;
	static {
		age = 10;
		name = "JLIN";
	}
	
	public Integer getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
}
