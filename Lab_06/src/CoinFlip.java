import java.util.Random;

public class CoinFlip {
	/**
	 * CoinFlip.java randomly picsk heads or tails and will stop when you get 3 heads in a row 
	 * Author: Brandon Altvater
	 *  Date: 3/28/2012
	 */

	public static void main(String[] args) {
		Random rand = new Random();

		int index = 0;
		int threeHeads = 0;

		while (threeHeads < 3) {
			int coin = rand.nextInt(2);
			if (coin == 0) {
				System.out.println("Tails");
				threeHeads = 0;
				index++;
			} else if (coin == 1) {
				System.out.println("Heads");
				threeHeads++;
				index++;
			}
		}
		System.out.println("It took " + index
				+ " flips to get 3 consecutive heads.");

	}

}
