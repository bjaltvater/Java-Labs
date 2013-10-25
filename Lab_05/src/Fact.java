import java.util.Scanner;

public class Fact {

	/**
	 * Fact.java finds the factorial of a number
	 * Author: Brandon Altvater
	 * Date: 3/1/2012
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		int number = keyboard.nextInt();

		int answer = factor(number);

		System.out.print("The factorial of your number is: " + answer);

	}

	/**
	 * Method for figuring out the factorial
	 * @param factorMe (int) this is the number to factor
	 * @return answer (long) this is the factored number
	 */
	public static int factor(int factorMe) {
		int answer = factorMe;
		while (factorMe > 1) {
			answer *= --factorMe;
		}
		return answer;
	}

}
