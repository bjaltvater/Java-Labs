import java.util.Scanner;

public class PropertyTester {

	/**
	 * PropertyTester.java allows the user to input an integer and test if the
	 * value are true or false in the properties library 
	 * Author: Brandon Altvater
	 * Date: 3/8/2012
	 */
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// Entering a number
		System.out.print("Enter a positive integer (enter 0 to quit): ");
		int number = keyboard.nextInt();
		while (number > 0 || number < 0) {
			if (number < 0) {
				System.out.println(number + " is not a postive integer!\n");
				System.out
						.print("Enter a positive integer (enter 0 to quit): ");
				number = keyboard.nextInt();
			} else if (number > 0) {
				// run one method that is called Property Testing
				System.out.println(PropertyTesting(number));
				System.out.print("Enter a positive integer (enter 0 to quit): ");
				number = keyboard.nextInt();
			}
		}
		System.out.println("Goodbye!!");
	}

	// Property Testing Method runs the user input againest all the boolean
	// tests in properties.java
	public static String PropertyTesting(int number) {
		if (Properties.isEven(number)) {
			System.out.println("The number " + number + " is even.");
		} else {
			System.out.println("The number " + number + " is not even.");
		}
		if (Properties.isOdd(number)) {
			System.out.println("The number " + number + " is odd.");
		} else {
			System.out.println("The number " + number + " is not odd.");
		}
		if (Properties.isPrime(number)) {
			System.out.println("The number " + number + " is prime.");
		} else {
			System.out.println("The number " + number + " is not prime.");
		}
		if (Properties.isPerfectSquare(number)) {
			System.out
					.println("The number " + number + " is a perfect square.");
		} else {
			System.out.println("The number " + number
					+ " is not a perfect square.");
		}
		if (Properties.isPerfectNumber(number)) {
			System.out
					.println("The number " + number + " is a perfect number.");
		} else {
			System.out.println("The number " + number
					+ " is not a perfect number.");
		}
		if (Properties.isFactorialNumber(number)) {
			System.out.println("The number " + number
					+ " is a factorial number.");
		} else {
			System.out.println("The number " + number
					+ " is not a factorial number.");
		}
		if (Properties.isFibonacciNumber(number)) {
			System.out.println("The number " + number
					+ " is a Fibonacci number.");
		} else {
			System.out.println("The number " + number
					+ " is not a Fibonacci number.");
		}
		return "";
	}
}
