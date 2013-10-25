import java.util.Scanner;

public class RectanglePerimeter
{

	/**RectanglePerimeter.java finds the perimeter of a rectangle
	 * Author: Brandon Altvater
	 * Date: 2/8/2012
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		double length;
		double width;
		double perimeter;
		
		
		System.out.print("Please input the length of the rectangle.");
		
		length = keyboard.nextDouble();
		
		System.out.print ("Please input the width of the ractangle.");
		
		width = keyboard.nextDouble();
		
		perimeter = length * 2 + width * 2;
		
		System.out.printf("The perimeter of the rectangle is %.2f ",perimeter);



	}

}
