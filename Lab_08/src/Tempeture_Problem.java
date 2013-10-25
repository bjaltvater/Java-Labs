import java.util.Scanner;

public class Tempeture_Problem {

	/**
	 * Tempetrure_Problem.java is a program that will ask you to input the
	 * tempetures for 7 tempetures then take the average, determine the highest,
	 * the lowest, and print the tempetures you entered 
	 * Author Brandon Altvater
	 * Date April 18th, 2012
	 * 
	 */
	public static void main(String[] args) {
		final int NUM_TEMP = 7;

		double[] temp = new double[NUM_TEMP];
		readTempInto(temp);
		System.out.printf("\nThe average is %.2f%n", average(temp));
		System.out.printf("\nThe highest temperature is %.2f%n", highest(temp));
		System.out.printf("\nThe highest temperature is %.2f%n", lowest(temp));
		print(temp);
	}

	public static double lowest(double[] temp) {
		double lowest = temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] < lowest) {
				lowest = temp[i];
			}
		}
		return lowest;
	}

	public static double highest(double[] temp) {
		double highest = temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] > highest) {
				highest = temp[i];
			}
		}
		return highest;
	}

	public static double average(double[] temp) {
		double sum = 0.0;
		for (int i = 0; i < temp.length; i++) {
			sum = sum + temp[i];
		}
		return sum/temp.length;
	}

	private static void readTempInto(double[] temp) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To compute the temperature");
		for (int i = 0; i < temp.length; i++) {
			System.out.print("Enter temperature " + (i + 1) + " of "
					+ temp.length + ": ");
			temp[i] = keyboard.nextDouble();
		}

	}
	public static void print(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Temperature #" + (i + 1) + ": " + arr[i]);

		}
	}

}
