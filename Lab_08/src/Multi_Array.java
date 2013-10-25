import java.util.Scanner;

public class Multi_Array {

	/**
	 * Multi_Array.java is a program that will ask you to input the number of
	 * rows you want your table to be and then produce a table with 4 coloums
	 * displaying the powers increasing accross the rows 
	 * Author Brandon Altvater
	 * Date April 18th, 2012
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out
				.println("Please enter in the number of rows you wish the table to be:");
		int rowSize = keyboard.nextInt();

		int[][] powerTable = new int[rowSize][4];
		readIntoRow(powerTable);

		for (int i = 0; i < powerTable.length; i++) {
			for (int j = 0; j < powerTable[i].length; j++) {
				System.out.printf("%8d", powerTable[i][j]);
			}
			System.out.println("");
		}
	}

	private static void readIntoRow(int[][] Table) {
		for (int i = 0; i < Table.length; i++) {
			int pos1 = i + 1;
			for (int j = 0; j < Table[i].length; j++) {
				int pos2 = (int) Math.pow(pos1, (j + 1));
				Table[i][j] = pos2;

			}

		}

	}

}
