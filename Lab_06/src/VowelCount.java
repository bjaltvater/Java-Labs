import java.util.Scanner;

public class VowelCount {

	public static void main(String[] args) {
		/**
		 * Vowelcount.java counts the number of vowels in your sentence 
		 * Author: Brandon Altvater
		 *  Date: 3/28/2012
		 */
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please type in a sentence:");
		String sentence = keyboard.nextLine();
		
		int index = 0;
		int aNumber = 0;
		int eNumber = 0;
		int iNumber = 0;
		int oNumber = 0;
		int uNumber = 0;
		while (index < sentence.length()){
			char vowel = sentence.charAt(index);
			if (vowel == 'a'){
				aNumber++;
			}else if (vowel == 'e'){
				eNumber++;
			}else if (vowel == 'i'){
				iNumber++;
			}else if (vowel == 'o'){
				oNumber++;
			}else if (vowel == 'u'){
				uNumber++;
			}
			index++;
		}
		System.out.println("Number of a's: " + aNumber);
		System.out.println("Number of e's: " + eNumber);
		System.out.println("Number of i's: " + iNumber);
		System.out.println("Number of o's: " + oNumber);
		System.out.println("Number of u's: " + uNumber);
	}

}
