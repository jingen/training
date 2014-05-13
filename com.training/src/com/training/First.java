package com.training;

import java.util.Date;

/**
 * @author jlin
 * First
 */
public class First extends Test implements TestInterface, TestInterface2 {
	private static final int SUM = 18;
	private int sum = 0;
	private Date date = new Date();

	/**
	 * Default Constructor
	 */
	First() {
	}

	/**
	 * Constructor with parameter sum
	 * 
	 * @param sum
	 */
	public First(int sum) {
		this.sum = sum;
	}

	/**
	 * Function: sum one to ten 
	 * 
	 * @return the sum of one to ten
	 */
	public int sumOneToTen() {
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}


	@SuppressWarnings("unused")
	private static void printNumber(int length) {
		for(int i=0; i<length; i++){
			System.out.println(i);
		}
	}

	@Override
	public int getResult() {
		return sumOneToTen();
	}

	@Override
	public String toString() {
		return "First [sum=" + SUM + "]";
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + sum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}

	public static void main(String[] main) {
		First first = new First();
		System.out.println(first.getResult());
		System.out.println(first);
	}

}
