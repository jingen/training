package com.training;

import java.util.Scanner;

import com.training.util.MathHelper;

public class Calculator {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		Calculator calculator = new Calculator();
//		calculator.calculate();
		new Calculator().calculate();
	}
	
	public void calculate(){
		String input1, input2, inputOp, ifContinueOrNot = "Y";
		InputHelper inputHelper = new InputHelper();
		double result = 0;
		while (ifContinueOrNot.equals("Y")) {
			input1 = inputHelper.getInput("Enter first number:");
			input2 = inputHelper.getInput("Enter second number:");
			inputOp = inputHelper.getInput("Enter the operation (+, -, *, /)");

			try {
				switch (inputOp) {
				case "+":
					result = MathHelper.add(input1, input2);
					break;
				case "-":
					result = MathHelper.subtract(input1, input2);
					break;
				case "*":
					result = MathHelper.multiply(input1, input2);
					break;
				case "/":
					result = MathHelper.divide(input1, input2);
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

			ifContinueOrNot = inputHelper.getInput("Continue? Y/N");
		}
	}
	class InputHelper{
		private Scanner scanner;

		private String getInput(String prompt){
			System.out.println(prompt);
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}
	}
	
}
