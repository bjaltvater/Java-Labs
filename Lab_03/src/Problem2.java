import java.util.Scanner;

public class Problem2 {

	/**
	 * Brandon Altvater
	 * Lab 3 - Excercise 2 - Dog Year Converter
	 * February 16, 2012
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);

		double dogYears;

		System.out.print("How old is your dog in human? ");
		double humanYears = keyboard.nextDouble();

		if (humanYears <= 2) 
		{
			dogYears = humanYears * 11;
		} 
		else 
		{
			dogYears = (2 * 11) + ((humanYears - 2) * 4);
		}

		System.out.println("Your dog is " + dogYears + " in dog years");

	}

}
