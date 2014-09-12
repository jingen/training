package com.training.effective.singleton;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s = "stringette";
//		System.out.println(s);
//		Case c = new Case();
//		System.out.println(c.getName());
//		System.out.println(c.getAge());
		long start = System.currentTimeMillis();
		Long sum = 0L;
//      1416(long) : 7960(Long)
//		prefer primitives to boxed primitives, and watch out for unintentional autoboxing
		for(long i=0; i < Integer.MAX_VALUE; i++){
			sum += i;
		}
		System.out.println(sum);
		long end= System.currentTimeMillis();
		System.out.println(end - start);
	}

}
