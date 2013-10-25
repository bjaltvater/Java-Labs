import java.util.Scanner;

public class Grades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int NUM_GRADES = 5;

		double[] grades = new double[NUM_GRADES];
		readGradesInto(grades);
		System.out.printf("\nThe average is %.2f%n", average(grades));
		print(grades);

	}

	private static void readGradesInto(double[] array) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To compute the grade ");
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter grade # " + (i + 1) + " of " + array.length
					+ ": ");
			array[i] = keyboard.nextDouble();
		}
	}

	public static double average(double[] anArray) {
		double sum = 0.0;
		for (int i = 0; i < anArray.length; i++) {
			sum = sum + anArray[i];
		}
		return sum / anArray.length;
	}

	public static void print(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Grade #" + (i + 1) + ": " + arr[i]);

		}
	}

}
