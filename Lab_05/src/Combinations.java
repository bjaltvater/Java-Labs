import java.util.Scanner;

public class Combinations {

	/**
	 * Combinations.java finds the number of possible combinations with two numbers
	 * Author: Brandon Altvater 
	 * Date: 3/1/2012
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter the number of objects in a set:");
		int setnumber = keyboard.nextInt();
		System.out.print("Enter the number of objects to be chosen from your set:");
		int outofnumber = keyboard.nextInt();

		int answer = Combine(setnumber, outofnumber);

		System.out.print("You can have " + answer + " number of combinations.");
	}
	/**
	 * Method for computing the number of combinations
	 * @param numberN (int), the top number to use in the equation
	 * @param numberK (int), the bottom number to use in the equation
	 * @return (int), using the combination formula of n!/ [k!*(n-k)!]
	 */
	public static int Combine(int numberN, int numberK) {
		int topNumber = Factor(numberN);
		int bottom1 = Factor(numberK);
		int bottom2 = Factor(numberN - numberK);

		return topNumber / (bottom1 * bottom2);
	}
	/**
	 * Method for figuring out the factorial
	 * @param number (int) this is the number to factor
	 * @return answer (int) this is the factored number
	 */
	public static int Factor(int number) {
		int answer = number;
		while (number > 1) {
			answer *= --number;
		}
		return answer;
	}
}
