import java.util.Scanner;

public class Problem3 {

	/**
	 * Brandon Altvater
	 * Lab 3 - Excercise 3 - Gross Pay Calculator
	 * February 16, 2012
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		double grossPay;
		
		System.out.print("Please input the number of hours you worked: ");
		double hoursWorked = keyboard.nextDouble();
		
		System.out.print("Please in the pay rate you recieve per hour: ");
		double payRate = keyboard.nextDouble();
		
		if (hoursWorked <= 40)
		{
			grossPay = hoursWorked * payRate;
		}
		else
		{
			grossPay = (40 * payRate) + ((hoursWorked - 40) * (payRate * 1.5));
		}
		
		System.out.printf("Your gross pay is $%.2f", grossPay);

		
	}

}
