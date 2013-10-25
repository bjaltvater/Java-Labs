import java.util.Scanner;
public class Problem_2 {

	/** Problem_2.java is a program that will let you enter in integers to be divided and tell you how many remainders
	 * Author: Brandon Altvater
	 * Date: 4/6/2012 
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int divided;
		int divisor;
		char answer;
		int quotient;
		int remainder;
		
		do{
			System.out.println("Please input the integer to be divided");
			divided = keyboard.nextInt();
			System.out.println("Please input the integer divisor");
			divisor = keyboard.nextInt();
			
			quotient = divided / divisor;
			remainder = divided % divisor;
			
			System.out.println(divided +" divided by " + divisor + " = " + quotient + " R " + remainder);
			
			System.out.println("Would you like to see the division result of two numbers, if not input no otherwise input anything you like");
			answer = keyboard.next().charAt(0);
						
		}while(answer != 'n' && answer != 'N');

	}

}
