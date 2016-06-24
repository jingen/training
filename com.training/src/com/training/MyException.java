package com.training;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3805034444418410531L;

	public MyException() {
		super("My Exception is thrown");
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
