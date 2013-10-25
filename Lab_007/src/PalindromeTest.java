import java.util.Scanner;

public class PalindromeTest {

	/**
	 * 
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String userWord;

		System.out.print("Please enter a word or phrase:");
		userWord = keyboard.nextLine();
		String testword = userWord.toLowerCase();
		String testword1 = removeSpaces(testword);
		String testword2 = reverseString(testword1);
		String testword3 = removeSpaces(testword);
		
		
		for (int i = 0; i < testword1.length(); i++) {
			if (testword2.charAt(i) == testword3.charAt(i)) {
				if( i == (testword1.length() - 1)){
					System.out.println("Your word " + userWord
							+ " is a pallindrome");
				}
					
			} else {
				System.out.println("Your word " + userWord
						+ " is not a pallindrome");
				i = userWord.length();
			}
		}
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

	private static String reverseString(String word) {
		String a = "";
		for (int i = (word.length() - 1); i >= 0; i--) {
			char c = word.charAt(i);
			a = a + c;
		}
		return a;
	}

}
