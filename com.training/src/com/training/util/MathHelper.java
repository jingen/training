package com.training.util;

public class MathHelper {
	public static double add(String input1, String input2) {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 + operand2;
	}

	public static double subtract(String input1, String input2) {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 - operand2;
	}

	public static double multiply(String input1, String input2) {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 * operand2;
	}

	public static double divide(String input1, String input2) {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 / operand2;
	}
}
