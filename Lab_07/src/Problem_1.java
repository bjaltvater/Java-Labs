import java.util.Scanner;
public class Problem_1 {

	/** Problem_1.java is a program that will let you make star boxes unless you tell the program "no"
	 * Author: Brandon Altvater
	 * Date : 4/6/2012 
	 */
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int height;
		int width;
		char answer;
		
		do{
			System.out.println("Please input the width of the box as an integer");
			width = keyboard.nextInt();
			System.out.println("Please in the height of the box as an integer");
			height =  keyboard.nextInt();
			
			for(int count1 = 1; count1 <= height; count1++){
				for (int count2 = 1; count2 <= width; count2++){
					System.out.print("*");
				}
				System.out.println();
			}
			
			System.out.println("If you want another box input anything but no otherwise type no.");
			answer = keyboard.next().charAt(0);
		} while (answer != 'n' && answer != 'N');

	}

}
