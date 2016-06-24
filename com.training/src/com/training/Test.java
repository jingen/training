package com.training;

import java.util.Scanner;


/**
 * @author jlin
 * Test
 */
public class Test{
	private static Scanner scanner;

	public void test(){
//		System.out.println("test");
	}
	
	public static void main(String[] args){
		try{
			throw new MyException();
		}catch(MyException me){
			System.out.println(me.getMessage());
		}
	}
}


