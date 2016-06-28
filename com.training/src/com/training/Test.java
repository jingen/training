package com.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		scanner = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add(scanner.nextLine());
		}
		System.out.println(list);
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String current = it.next();
			if(current.contains("ok")){
				it.remove();
			}
		}
		System.out.println(list);
	}
}


