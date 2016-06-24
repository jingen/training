package com.training;

import java.util.Scanner;

public class Calculator {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input1, input2, inputOp, ifContinueOrNot = "Y";
		double result = 0;
		while (ifContinueOrNot.equals("Y")) {
			System.out.print("Enter first number:");
			input1 = scanner.nextLine();
			System.out.print("Enter second number:");
			input2 = scanner.nextLine();
			System.out.print("Enter the operation (+, -, *, /)");
			inputOp = scanner.nextLine();

			try {
				switch (inputOp) {
				case "+":
					result = add(input1, input2);
					break;
				case "-":
					result = subtract(input1, input2);
					break;
				case "*":
					result = multiply(input1, input2);
					break;
				case "/":
					result = divide(input1, input2);
					break;
				default:
					throw new Exception("Unrecognized operator.");
				}
				System.out.println("The result is: " + Double.toString(result));
			} catch (NumberFormatException nf) {
				System.out.println(nf.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Continue?");
			ifContinueOrNot = scanner.nextLine();

		}
	}

	public static double add(String input1, String input2)
			throws NumberFormatException {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 + operand2;
	}

	public static double subtract(String input1, String input2)
			throws NumberFormatException {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 - operand2;
	}

	public static double multiply(String input1, String input2)
			throws NumberFormatException {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 * operand2;
	}

	public static double divide(String input1, String input2)
			throws NumberFormatException {
		double operand1 = Double.parseDouble(input1);
		double operand2 = Double.parseDouble(input2);
		return operand1 / operand2;
	}
}
