import java.util.Scanner;

public class WordScore {
	/**
	 * WordScore.java determines the score of your word based in scrabble 
	 * Author: Brandon Altvater
	 *  Date: 3/28/2012
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter a word: ");
		String word = keyboard.nextLine();
		String word2 = word.toLowerCase();

		int index = 0;
		int onePoint = 0;
		int twoPoint = 0;
		int threePoint = 0;
		int fourPoint = 0;
		int fivePoint = 0;
		int eightPoint = 0;
		int tenPoint = 0;

		while (index < word.length()) {
			char letter = word2.charAt(index);
			if (letter == 'a' || letter == 'e' || letter == 'i'
					|| letter == 'l' || letter == 'n' || letter == 'o'
					|| letter == 'r' || letter == 's' || letter == 't'
					|| letter == 'u') {
				onePoint++;
			} else if (letter == 'd' || letter == 'g') {
				twoPoint++;
			} else if (letter == 'b' || letter == 'c' || letter == 'm'
					|| letter == 'p') {
				threePoint++;
			} else if (letter == 'f' || letter == 'h' || letter == 'v'
					|| letter == 'w' || letter == 'y') {
				fourPoint++;
			} else if (letter == 'k') {
				fivePoint++;
			} else if (letter == 'j' || letter == 'x') {
				eightPoint++;
			} else if (letter == 'q' || letter == 'z') {
				tenPoint++;
			}
			index++;
		}
		int totalpoints = (onePoint * 1) + (twoPoint * 2) + (threePoint * 3)
				+ (fourPoint * 4) + (fivePoint * 5) + (eightPoint * 8)
				+ (tenPoint * 10);

		System.out.println("The word " + word + " is worth " + totalpoints
				+ " points.");

	}

}
