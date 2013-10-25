import java.util.Scanner;

public class Problem4 {

	/**
	 * Brandon Altvater
	 * Lab 3 - Excercise 4 - Problem 2 with a sential data marker
	 * February 16, 2012
	 */
	public static void main(String[] args) 
	{
		
		Scanner keyboard = new Scanner(System.in);

		double dogYears;

		System.out.print("How old is your dog in human years, Enter -1 to stop? ");
		double humanYears = keyboard.nextDouble();
		
		while (humanYears != -1)
		{
			if (humanYears <= 2) 
			{
				dogYears = humanYears * 11;
			} 
			else 
			{
				dogYears = (2 * 11) + ((humanYears - 2) * 4);
			}
			
			System.out.println("Your dog is " + dogYears + " in dog years");
			System.out.print("How old is your dog in human years, Enter -1 to stop? ");
			humanYears = keyboard.nextDouble();

		}
	}

}
