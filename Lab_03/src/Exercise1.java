import java.util.Scanner;

public class Exercise1 {

	/**
	 * Brandon Altvater 
	 * Problem 1 - The Greeter Program
	 * February 16, 2012
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please type in your name: ");
		String name = keyboard.next();

		System.out.println("Welcome to Java " + name);

	}

}
