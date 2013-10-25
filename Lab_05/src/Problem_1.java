import java.util.Scanner;

public class Problem_1 {

	/**
	 * Problem_1.java finds the engery of an object given the mass
	 * Author: Brandon Altvater
	 * Date: 3/1/2012
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Get the mass of the object
		System.out.print("Please input the mass in kilograms:");
		int objectMass = keyboard.nextInt();

		long calculation = Calculate(objectMass);

		System.out.print("The energy is " + calculation);

	}

	/**
	 * Energy calculation
	 * @param mass, (double) mass of the object
	 * @return energy, (double) engery using Einstien's Formula
	 */
	public static long Calculate(int mass) {
		final long light = 299792458;
		return (long) (mass * Math.pow(light, 2));
	}

}
