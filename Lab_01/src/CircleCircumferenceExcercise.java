import java.util.Scanner;

public class CircleCircumferenceExcercise
{

	/**CircleCircumferenceExcercise.java finds the perimeter of a rectangle
	 * Author: Brandon Altvater
	 * Date: 2/8/2012
	 */
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		final double PI = 3.14;
		
		double radius;
		double circumference;
		double area;
				
		System.out.print ("Please input the radius.");
		
		radius = keyboard.nextDouble();
		
		circumference = 2 * PI * radius;
		area = PI * (radius * radius);
		
		System.out.println("The circumference of the circle is "+ circumference);
		System.out.printf("The area of the circle is %.2f", area);
		



	}

}
