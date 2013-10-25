import java.util.Scanner;

public class StringExample {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		String sentence = keyboard.nextLine();
		
		
		int index = 0;
		while (index < sentence.length()){
			char cc = sentence.charAt(index);
			if (cc == 's') System.out.println("yes");;
//			System.out.println(cc);
			index ++;
			
		}
		
		
		


	}

}
