import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dice_Roll {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the number of times to roll the dice");
		int rolls = keyboard.nextInt();
		int[] diceCount = new int[rolls];
		readdiceInto(diceCount);
		totalCount(diceCount);
		System.out.println(Arrays.toString(diceCount));

	}

	private static void totalCount(int[] diceCount) {
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0;
		int fiveCount = 0;
		int sixCount = 0;
		int sevenCount = 0;
		int eightCount = 0;
		int nineCount = 0;
		int tenCount = 0;
		int elevenCount = 0;
		int twelveCount = 0;
		for (int i = 0; i < diceCount.length; i++) {			
			int dieNumber = diceCount[i];
			switch (dieNumber) {
			case 2:
				twoCount++;
				break;
			case 3:
				threeCount++;
				break;
			case 4:
				fourCount++;
				break;
			case 5:
				fiveCount++;
				break;
			case 6:
				sixCount++;
				break;
			case 7:
				sevenCount++;
				break;
			case 8:
				eightCount++;
				break;
			case 9:
				nineCount++;
				break;
			case 10:
				tenCount++;
				break;
			case 11:
				elevenCount++;
				break;
			case 12:
				twelveCount++;
				break;
			}

		}
		System.out.printf("%s %10s %10s\n","Number","Observed", "Expected");
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 2, (float)twoCount/diceCount.length * 100, 2.78);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 3, (float)threeCount/diceCount.length * 100, 5.56);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 4, (float)fourCount/diceCount.length * 100, 8.33);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 5, (float)fiveCount/diceCount.length * 100, 11.11);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 6, (float)sixCount/diceCount.length * 100, 13.89);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 7, (float)sevenCount/diceCount.length * 100, 16.67);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 8, (float)eightCount/diceCount.length * 100, 13.89);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 9, (float)nineCount/diceCount.length * 100, 11.11);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 10, (float)tenCount/diceCount.length * 100, 8.33);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 11, (float)elevenCount/diceCount.length * 100, 5.56);
		System.out.printf("%6d %9.2f%% %9.2f%%\n", 12, (float)twelveCount/diceCount.length * 100, 2.78);
	
	}
	
	private static void readdiceInto(int[] rolls) {
		Random rand = new Random();
		for (int i = 0; i < rolls.length; i++) {
			int die1 = rand.nextInt(6) + 1;
			int die2 = rand.nextInt(6) + 1;

			int sum = die1 + die2;

			rolls[i] = sum;

		}

	}

}
