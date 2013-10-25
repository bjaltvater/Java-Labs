import java.util.Scanner;

public class Reverser {

	/**
	 * 
	 */
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
	String revstr;
	
	System.out.print("Please enter in a word to be reversed:");
	revstr = keyboard.nextLine();
	
	System.out.println("Original word:" + revstr);
	System.out.println("Reversed word:" + reverseString(revstr));

	}
	
	private static String reverseString(String word){
		String a = "";
		for(int i = (word.length() - 1); i >= 0; i--){
			char c = word.charAt(i);
			a = a + c;
		}
		return a;
	}

}
