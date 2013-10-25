import java.util.Scanner;

public class SpaceRemover {

	/** SpaceRemover.java is a program that will remove the spaces in a string that you put in as the input
	 * Author: Brandon Altvater
	 * Date : 4/6/2012 
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		String spaceOut;

		System.out.print("Please enter a sentence:");
		spaceOut = keyboard.nextLine();

		System.out.println("Original word:" + spaceOut);
		System.out.println("Spaces removed:" + removeSpaces(spaceOut));

	}

	private static String removeSpaces(String word) {
		String a = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c != ' ') {
				a = a + c;
			}
		}
		return a;
	}

}
