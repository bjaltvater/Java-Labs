import java.util.Scanner;

public class PropertyTester_EC {

	/**
	 * EXTRA CREDIT PropertyTester_EC.java allows the user to input anything but
	 * will only work if the input is a positive integer otherwise it will
	 * direct them to re-enter a number 
	 * Author: Brandon Altvater
	 *  Date: 3/8/2012
	 */

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// Enter a number then testing to see if the value entered is an integer
		System.out.print("Enter a positive integer (enter 0 to quit): ");
		while (keyboard.hasNextLine()) {
			if (keyboard.hasNextInt()) {
				int number = keyboard.nextInt();
				if (number == 0) {
					System.out.println("Goodbye!!");
					break;
				} else if (number < 0) {
					System.out.println(number + " is not a postive integer!\n");
				} else if (number > 0) {
					// Runs the Propery Testing Method which then tests the
					// properties
					System.out.println(PropertyTesting((int) number));
				}
			} else if (keyboard.hasNextDouble()) {
				double wrong = keyboard.nextDouble();
				System.out.print(wrong + " is not an integer!\n");
			} else if (keyboard.hasNextLine()) {
				String wrong = keyboard.next() + keyboard.nextLine();
				System.out.print(wrong + " is not an integer!\n");
			}
			System.out.print("Enter a positive integer (enter 0 to quit): ");
		}
	}

	// Property Testing Method, tests the input number to determine properties
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
