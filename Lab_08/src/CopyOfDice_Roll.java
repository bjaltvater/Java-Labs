import java.util.Random;
import java.util.Scanner;

public class CopyOfDice_Roll {

	/**
	 * CopyOfDice_Roll.java is a program that will ask you to input the number
	 * of times you want to roll 2 six sided die, compute the sum and then
	 * display your observed probability of what you got and the expected probabilities 
	 * Author Brandon Altvater
	 * Date April 18th, 2012
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the number of times to roll the dice");
		int rolls = keyboard.nextInt();
		rollDice(rolls);
	}

	private static void rollDice(int rolls) {
		Random rand = new Random();
		int[] diceCount = new int[11];
		double[] prob = { 2.78, 5.56, 8.33, 11.11, 13.89, 16.67, 13.89, 11.11,
				8.33, 5.56, 2.78 };// an array just for my probabilities that
									// help make 1 printf statement
		for (int i = 0; i < rolls; i++) {
			int die1 = rand.nextInt(6) + 1;
			int die2 = rand.nextInt(6) + 1;
			int sum = die1 + die2;

			diceCount[sum - 2] = diceCount[sum - 2] + 1;

		}
		System.out.printf("%s %10s %10s\n", "Number", "Observed", "Expected");
		for (int i = 0; i < diceCount.length; i++) {
			System.out.printf("%6d %9.2f%% %9.2f%%\n", (i + 2),
					(float) diceCount[i] / rolls * 100, prob[i]);
		}
	}
}
