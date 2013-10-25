import java.util.Arrays;
import java.util.Scanner;

public class PokerHandsExtra {

	/********************************************************/
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		while (option != 1 && option != 2) {
			System.out.println("Enter 1 for randomly generated hands.");
			System.out.println("Enter 2 for preconstructed hands.");
			System.out.print("======> ");
			option = keyboard.nextInt();
		}

		if (option == 1)
			evaluateRandomHands();
		else if (option == 2)
			evaluatePreconstructedHands();
	}

	/********************************************************/
	public static void evaluatePreconstructedHands() {
		Card[] hand1;
		Card[] hand2;

		// ---------------------
		hand1 = createHand("H2", "C3", "H4", "H6", "H5");
		hand2 = createHand("SA", "C5", "S4", "S3", "S2");
		doOneEvaluation(hand1, hand2);

		// ---------------------
		hand1 = createHand("H8", "D9", "ST", "C7", "HJ");
		hand2 = createHand("C8", "S9", "HT", "S7", "SJ");
		doOneEvaluation(hand1, hand2);

		// ---------------------
		hand1 = createHand("H6", "H6", "D4", "DJ", "H5");
		hand2 = createHand("SJ", "S4", "C4", "C8", "S3");
		doOneEvaluation(hand1, hand2);
	}


	/********************************************************/
	public static Card[] createHand(String c0, String c1, String c2, String c3,
			String c4) {
		Card card0 = new Card(c0.charAt(0), c0.charAt(1));
		Card card1 = new Card(c1.charAt(0), c1.charAt(1));
		Card card2 = new Card(c2.charAt(0), c2.charAt(1));
		Card card3 = new Card(c3.charAt(0), c3.charAt(1));
		Card card4 = new Card(c4.charAt(0), c4.charAt(1));
		Card[] hand = { card0, card1, card2, card3, card4 };
		return hand;
	}

	/********************************************************/
	public static void evaluateRandomHands() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many hand comparisons should be done? ");
		int numHands = keyboard.nextInt();
		System.out.println();

		int handCount = 0;
//		while (handCount < numHands) {
//			CardDeck deck = new CardDeck();
//			deck.shuffleDeck();
//			Card[] hand1 = deck.dealCards(5);
//			Card[] hand2 = deck.dealCards(5);
//			doOneEvaluation(hand1, hand2);
//			handCount++;
//		}
	}

	/********************************************************/
	public static void doOneEvaluation(Card[] hand1, Card[] hand2) {
		sortCards(hand1);
		sortCards(hand2);
		System.out.println("Hand 1: " + Arrays.toString(hand1));
		System.out.println("Hand 2: " + Arrays.toString(hand2));

		int winner = winner(hand1, hand2);
		if (winner == 1)
			System.out.println("hand 1 wins");
		else if (winner == 2)
			System.out.println("hand 2 wins");
		else
			System.out.println("it's a tie");

		System.out.println();
	}

	/********************************************************/
	public static int winner(Card[] hand1, Card[] hand2) {

		String best = "The best hand is ";
		String both = "Both hands are ";

		// Straight flush ------------------------------/
		boolean straightflush1 = isStraightFlush(hand1);
		boolean straightflush2 = isStraightFlush(hand2);
		if (straightflush1 && straightflush2) {
			System.out.println(both + "a straight flush ");
			return breakStraightFlush(hand1, hand2);
		} else if (straightflush1 && !straightflush2) {
			System.out.println(best + "a straight flush ");
			return 1;
		} else if (!straightflush1 && straightflush2) {
			System.out.println(best + "a straight flush ");
			return 2;
		}

		// Four of a kind (quads) ----------------------/
		boolean quads1 = isQuads(hand1);
		boolean quads2 = isQuads(hand2);
		if (quads1 && quads2) {
			System.out.println(both + "4 of a kind ");
			return breakQuads(hand1, hand2);
		} else if (quads1 && !quads2) {
			System.out.println(best + "4 of a kind ");
			return 1;
		} else if (!quads1 && quads2) {
			System.out.println(best + "4 of a kind ");
			return 2;
		}

		// Full house (fullboat) -----------------------/
		boolean fullboat1 = isFullBoat(hand1);
		boolean fullboat2 = isFullBoat(hand2);
		if (fullboat1 && fullboat2) {
			System.out.println(both + "a full house ");
			return breakFullBoat(hand1, hand2);
		} else if (fullboat1 && !fullboat2) {
			System.out.println(best + "a full house ");
			return 1;
		} else if (!fullboat1 && fullboat2) {
			System.out.println(best + "a full house ");
			return 2;
		}

		// Flush ---------------------------------------/
		boolean flush1 = isFlush(hand1);
		boolean flush2 = isFlush(hand2);
		if (flush1 && flush2) {
			System.out.println(both + "a flush ");
			return breakFlush(hand1, hand2);
		} else if (flush1 && !flush2) {
			System.out.println(best + "a flush ");
			return 1;
		} else if (!flush1 && flush2) {
			System.out.println(best + "a flush ");
			return 2;
		}

		// Straight ------------------------------------/
		boolean straight1 = isStraight(hand1);
		boolean straight2 = isStraight(hand2);
		if (straight1 && straight2) {
			System.out.println(both + "a straight ");
			return breakStraight(hand1, hand2);
		} else if (straight1 && !straight2) {
			System.out.println(best + "a straight ");
			return 1;
		} else if (!straight1 && straight2) {
			System.out.println(best + "a straight ");
			return 2;
		}

		// Three of a kind (trips) ----------------------/
		boolean trips1 = isTrips(hand1);
		boolean trips2 = isTrips(hand2);
		if (trips1 && trips2) {
			System.out.println(both + "3 of a kind ");
			return breakTrips(hand1, hand2);
		} else if (trips1 && !trips2) {
			System.out.println(best + "3 of a kind ");
			return 1;
		} else if (!trips1 && trips2) {
			System.out.println(best + "3 of a kind ");
			return 2;
		}

		// Two pair ------------------------------------/
		boolean twopair1 = isTwoPair(hand1);
		boolean twopair2 = isTwoPair(hand2);
		if (twopair1 && twopair2) {
			System.out.println(both + "two pair ");
			return breakTwoPair(hand1, hand2);
		} else if (twopair1 && !twopair2) {
			System.out.println(best + "two pair ");
			return 1;
		} else if (!twopair1 && twopair2) {
			System.out.println(best + "two pair ");
			return 2;
		}

		// One pair ------------------------------------/
		boolean onepair1 = isOnePair(hand1);
		boolean onepair2 = isOnePair(hand2);
		if (onepair1 && onepair2) {
			System.out.println(both + "one pair ");
			return breakOnePair(hand1, hand2);
		} else if (onepair1 && !onepair2) {
			System.out.println(best + "one pair ");
			return 1;
		} else if (!onepair1 && onepair2) {
			System.out.println(best + "one pair ");
			return 2;
		}

		// High card -----------------------------------/
		System.out.println(both + "a highcard ");
		return breakHighCard(hand1, hand2);

	}

	/********************************************************/
	public static boolean isStraightFlush(Card[] hand) {
		if (isFlush(hand) && isStraight(hand)) {
			return true;
		}

		return false;
	}

	public static int breakStraightFlush(Card[] hand1, Card[] hand2) {
		// returns 1 if hand1 wins, 2 if hand2 wins,
		// and 0 if it's a tie
		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}
		// If you have a low straight flush the 12 array position gets a value of 0	
		if (hand1[0].worth == 14 && hand1[1].worth == 5 && hand1[2].worth == 4
				&& hand1[3].worth == 3 && hand1[4].worth == 2) {
			hand1Counter[12]=0;			
		}
		if (hand2[0].worth == 14 && hand2[1].worth == 5 && hand2[2].worth == 4
				&& hand2[3].worth == 3 && hand2[4].worth == 2) {
			hand2Counter[12]=0;			
		}
		for (int i = 12; i>=0;i--){
			if (hand1Counter[i]>hand2Counter[i]){
				return 1;
			}
			if (hand2Counter[i]>hand1Counter[i]){
				return 2;
			}
			
		}

		return 0;
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

	public static int breakQuads(Card[] hand1, Card[] hand2) {
		// returns 1 if hand1 wins, 2 if hand2 wins,
		// and 0 if it's a tie
		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}		
		for (int i = 12; i >= 0; i--) {
			if (hand1Counter[i] == 4) {
				return 1;

			} else if (hand2Counter[i] == 4) {
				return 2;
			}
		}
		return 0;
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

	public static int breakFullBoat(Card[] hand1, Card[] hand2) {
		
		return breakTrips(hand1,hand2);

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

	public static int breakTrips(Card[] hand1, Card[] hand2) {

		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}
		for (int i = 12; i >= 0; i--) {
			if (hand1Counter[i] == 3) {
				return 1;

			} else if (hand2Counter[i] == 3) {
				return 2;
			}
		}
		return 0;
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

	public static int breakFlush(Card[] hand1, Card[] hand2) {

		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}
		
		for (int i = 12; i >= 0; i--) {
			if (hand1Counter[i] > hand2Counter[i]) {
				return 1;

			} else if (hand2Counter[i] > hand1Counter[i]) {
				return 2;
			}
		}
		return 0;
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

	public static int breakStraight(Card[] hand1, Card[] hand2) {
		return breakStraightFlush(hand1,hand2);

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

	public static int breakTwoPair(Card[] hand1, Card[] hand2) {
		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}
		
		for (int i = 12; i >= 0; i--) {
			if (hand1Counter[i] > hand2Counter[i]) {
				return 1;

			} else if (hand2Counter[i] > hand1Counter[i]) {
				return 2;
			}
		}
		return 0;
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

	public static int breakOnePair(Card[] hand1, Card[] hand2) {
		int[] hand1Counter = new int[13];
		int[] hand2Counter = new int[13];
		for (int i = 0; i < hand1.length; i++) {
			hand1Counter[hand1[i].worth - 2] = hand1Counter[hand1[i].worth - 2] + 1;
			hand2Counter[hand2[i].worth - 2] = hand2Counter[hand2[i].worth - 2] + 1;
		}
		
		for (int i = 12; i >= 0; i--) {
			if (hand1Counter[i] == 2) {
				return 1;

			} else if (hand2Counter[i] == 2) {
				return 2;
			}
		}
		return 0;
	}

	/********************************************************/
	public static int breakHighCard(Card[] hand1, Card[] hand2) {
		for (int i = 0; i < hand1.length; i++) {
			if (hand1[i].worth > hand2[i].worth) {
				return 1;

			} else if (hand2[i].worth > hand1[i].worth) {
				return 2;
			}
		}
		return 0;
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
