import java.util.Scanner;

public class Einstien {

	/**Einstien.java finds the engery of an object given the mass
	 * Author: Brandon Altvater
	 * Date: 3/1/2012
	 */
	public static void main(String[] args) {
		
		Scanner keyboard =  new Scanner(System.in);
		// get the mass of the object
		
		System.out.print("Please input the mass in kilograms:");
		long objectMass = keyboard.nextLong();
		
		long calculation = Calculation.energy(objectMass);
		
		System.out.print("The energy is "+ calculation);
		
		
		
		

	}

}
