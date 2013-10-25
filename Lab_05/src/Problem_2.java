import java.util.Scanner;

public class Problem_2 {

	/**
	 * Problem_2.java finds the area, circumference, and volume of a circle giving a radius if you enter negative number the program will stop
	 * Author:Brandon Altvater
	 * Date: 3/1/2012
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input the radius of the circle type a negative number to quit:");
		double inputRadius = keyboard.nextDouble();
		
		// Sential while loop while executing the area, circumference, and volume methods
		while (inputRadius >= 0){
			System.out.printf("The area of the circle is %.2f \n", Circle.Area(inputRadius) );
			System.out.printf("The circumference of the circle is %.2f \n", Circle.Circumference(inputRadius) );
			System.out.printf("The volume of the circle is %.2f \n", Circle.Volume(inputRadius) );
			
			System.out.println("Please input the radius of the circle type a negative number to quit:");
			inputRadius = keyboard.nextDouble();
		}
		System.out.println("Thank you come again!");
	
	}
	
}
