import java.util.Arrays;
import java.util.Scanner;

public class PokerHands {

	public static void computeHandOdds(Card[] hand1) {

			sortCards(hand1);
			if (isStraightFlush(hand1)) {
				Hand_Reader.result = "Straight Flush";
			} else if (isQuads(hand1)) {
				Hand_Reader.result = "Four of a Kind";
			} else if (isFullBoat(hand1)) {
				Hand_Reader.result = "Full House";
			} else if (isFlush(hand1)) {
				Hand_Reader.result = "Flush";
			} else if (isStraight(hand1)) {
				Hand_Reader.result = "Straight";
			} else if (isTrips(hand1)) {
				Hand_Reader.result = "Three of a Kind";
			} else if (isTwoPair(hand1)) {
				Hand_Reader.result = "Two Pair";
			} else if (isOnePair(hand1)) {
				Hand_Reader.result = "One Pair";
			} else {
				Hand_Reader.result = "High Card";
			}
		} 

	/********************************************************/
	public static void displayHandOdds(int numHands, int numStraightFlush,
			int numQuads, int numFullBoat, int numFlush, int numStraight,
			int numTrips, int numTwoPair, int numOnePair, int numHighCard) {

		String[] handType = { "Straight Flush", "Four of a Kind", "Full House",
				"Flush", "Straight", "Three of a Kind", "Two Pair", "One Pair",
				"High Card" };
		int[] handCounter = { numStraightFlush, numQuads, numFullBoat,
				numFlush, numStraight, numTrips, numTwoPair, numOnePair,
				numHighCard };
		double[] prob = { .0015, .024, .14, .196, .39, 2.11, 4.75, 42.52, 50.11 };

		System.out.printf("%-15s %12s %12s %13s\n", "Hand Type", "Observed",
				"Expected", "Hand Count");
		System.out.printf("%-15s %12s %12s %13s\n", "---------------",
				"--------", "--------", "----------");
		for (int i = 0; i < handCounter.length; i++) {
			System.out.printf("%-15s %11.4f%% %11.4f%% %13d\n", handType[i],
					(float) handCounter[i] / numHands * 100, prob[i],
					handCounter[i]);
		}

	}

	/********************************************************/
	public static boolean isStraightFlush(Card[] hand) {

		if (isFlush(hand) && isStraight(hand)) {
			return true;
		}

		return false;
	}

	/********************************************************/
	public static boolean isQuads(Card[] hand) {

		for (int i = 0; i < 2; i++) {
			if (hand[i].worth == hand[i + 1].worth
					&& hand[i].worth == hand[i + 2].worth
					&& hand[i].worth == hand[i + 3].worth) {
				return true;
			}
		}

		return false;
	}

	/********************************************************/
	public static boolean isFullBoat(Card[] hand) {

		int BoatCount = 0;
		for (int index = 0; index < hand.length; index++) {
			for (int i = index + 1; i < hand.length; i++) {
				if (hand[i].worth == hand[index].worth) {
					BoatCount++;
					if (BoatCount > 3 && BoatCount < 5) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/********************************************************/
	public static boolean isTrips(Card[] hand) {

		int TripCount = 0;
		for (int index = 0; index < hand.length; index++) {
			for (int i = index + 1; i < hand.length; i++) {
				if (hand[i].worth == hand[index].worth) {
					TripCount++;
					if (TripCount > 2 && TripCount < 4) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/********************************************************/
	public static boolean isFlush(Card[] hand) {

		char suit = hand[0].suit;
		for (int i = 1; i < hand.length; i++) {
			if (hand[i].suit != suit) {
				return false;

			}

		}

		return true;
	}

	/********************************************************/
	public static boolean isStraight(Card[] hand) {

		int straightCount = 0;

		for (int index = 0; index < hand.length; index++) {
			for (int i = index + 1; i < hand.length; i++) {
				if (hand[i].worth == hand[index].worth - 1) {
					straightCount++;
					index++;
					if (straightCount == 4) {
						index = hand.length;
						return true;
					}

				}
			}

		}
		if (hand[0].worth == 14 && hand[1].worth == 5 && hand[2].worth == 4
				&& hand[3].worth == 3 && hand[4].worth == 2) {
			return true;
		}
		return false;
	}

	/********************************************************/
	public static boolean isTwoPair(Card[] hand) {

		int pairCount = 0;
		for (int index = 0; index < hand.length; index++) {
			for (int i = index + 1; i < hand.length; i++) {
				if (hand[i].worth == hand[index].worth) {
					i = i + 1;
					index = index + 2;
					pairCount++;
					if (pairCount == 2) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/********************************************************/
	public static boolean isOnePair(Card[] hand) {

		for (int i = 0; i < 4; i++) {
			if (hand[i].worth == hand[i + 1].worth) {
				return true;
			}
		}
		return false;
	}

	/********************************************************/
	public static void sortCards(Card[] hand) {

		for (int index = 0; index < hand.length; index++) {
			int max = index;
			for (int i = index; i < hand.length; i++) {
				if (hand[i].worth > hand[max].worth) {
					max = i;
				}
			}
			Card temp = hand[max];
			hand[max] = hand[index];
			hand[index] = temp;
		}
	}
}
