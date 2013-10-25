import java.util.Scanner;

public class CharProgram {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = keyboard.nextLine();
        String newstr1 = str.toLowerCase();
        System.out.println("java: " + newstr1);
        String newstr2 = toLowerCase(str);
        System.out.println("mine: " + newstr2);
    }
    
    private static String toLowerCase(String str) {
        String newstr = "";
        for(int pos = 0; pos < str.length(); pos++){
        	  char ch = str.charAt(pos);
              char newch = toLowerCase(ch);
              newstr = newstr + newch;
              
        }
        return newstr;
    }

    private static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 'a' - 'A');
        } else {
            return ch;
        }
    }
}