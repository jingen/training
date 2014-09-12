package com.training.effective.singleton;

/**
 * A singleton is simply a class that is instantiated exactly once
 * @author jlin
 *
 */
public class Elvis {
	/**
	 * The private constructor is called only once, 
	 * to initialize the public static final field Elvis.INSTANCE.
	 */
//	public static final Elvis INSTANCE = new Elvis();

	/**
	 * The main advantage of the public field approach is that 
	 * the declarations make it clear that the class is a singleton:
	 */
	private static final Elvis INSTANCE = new Elvis();
	private Elvis(){}

	/**
	 * One advantage of the factory-method approach is that 
	 * it gives you the flexibility to change your mind about 
	 * whether the class should be a singleton without changing its API.
	 * @return
	 */
	public static Elvis getInstance(){
		return INSTANCE;
	}
	
	public void leaveTheBuilding(){
		System.out.println(this);
	}

}
