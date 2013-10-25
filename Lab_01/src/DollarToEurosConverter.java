import java.util.Scanner;

public class DollarToEurosConverter 
{

	/**DollarsToEurosconverter.java converts dollars to euros
	 * Author: Brandon Altvater
	 * Date: 2/8/2012
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		double dollars;
		double eurosPerDollar;
				
		System.out.print ("How many dollars do you want to convert? ");
		dollars = keyboard.nextDouble();	
		
		System.out.print ("What is the euro-per-dollar exchange rate? ");
		eurosPerDollar = keyboard.nextDouble();
		
		double euros = dollars * eurosPerDollar;
		
		System.out.printf ("$%.2f dollars = $%.2f euros", dollars, euros);
		
		//System.out.println (dollars + "dollars = " + euros +"euros");
		
		

	}

}
