import java.util.Scanner;


public class MileToKiloConverter
{

	/**MileToKiloconverter.java converts miles to kilometers
	 * Author: Brandon Altvater
	 * Date: 2/8/2012
	 */
	public static void main(String[] args) 
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		double miles;
		double kilometers;

		System.out.print ("How many miles do you want to convert? ");
		
		miles = keyboard.nextDouble();
		
		kilometers = miles * 1.60934;
		
		System.out.printf ("%.2f miles = %.2f kilometers", miles, kilometers);
		
		

	}

}
