import java.util.Arrays;
import java.util.Scanner;

public class PokerHands {

    /********************************************************/
    public static void main(String[] args) {
        computeHandOdds();
    }

    /********************************************************/
    public static void computeHandOdds() {

        /*
         * Ask the user (1) how many hands should be considered and (2) whether
         * or not details about each hand should be displayed during processing.
         * The information is stored in appropriately named variables.
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many hands should be considered? ");
        int numHands = keyboard.nextInt();
        System.out.print("Should deck and hand details be displayed (y/n)? ");
        String displayChoice = keyboard.next();
        boolean displayDetails = displayChoice.toLowerCase().startsWith("y");

        /*
         * Initialize counters used to keep track of how many hands of various
         * types are dealt. There are nine different hand types. See
         * http://en.wikipedia.org/wiki/List_of_poker_hands
         */
        int numStraightFlush = 0;
        int numQuads = 0; // quads is another name for four of a kind
        int numFullBoat = 0; // full boat is another name for full house
        int numFlush = 0;
        int numStraight = 0;
        int numTrips = 0; // trips is another name for three of a kind
        int numTwoPair = 0;
        int numOnePair = 0;
        int numHighCard = 0;

        int handCount = 0;
        while (handCount < numHands) {

            /*
             * (1) create a new deck object, (2) shuffle the deck, and (3)
             * output a message indicating that a new deck has been created, if
             * the user indicated that details should be displayed.
             */
            CardDeck deck = new CardDeck();
            deck.shuffleDeck();
            if (displayDetails)
                System.out.println("*** new deck ***");

            /*
             * Repeats the following as long as there are enough cards in the
             * deck to deal a 5-card hand: (1) deal a 5-card hand from the deck,
             * (2) sort the hand in descending order for easier processing (note
             * you will write the code to do this in a separate method below),
             * (3) determine the type of hand (e.g., "Four of a kind") and
             * increment the corresponding counter. A separate method should be
             * used for each of the seven hand types. (4) display the hand and
             * its type, if the user indicated that details should be displayed.
             */
            do {
                String result = "";
                Card[] hand1 = deck.dealCards(5);
                sortCards(hand1);
                if (isStraightFlush(hand1)) {
                    numStraightFlush++;
                    result = "Straight Flush";
                } else if (isQuads(hand1)) {
                    numQuads++;
                    result = "Four of a Kind";
                } else if (isFullBoat(hand1)) {
                    numFullBoat++;
                    result = "Full House";
                } else if (isFlush(hand1)) {
                    numFlush++;
                    result = "Flush";
                } else if (isStraight(hand1)) {
                    numStraight++;
                    result = "Straight";
                } else if (isTrips(hand1)) {
                    numTrips++;
                    result = "Three of a Kind";
                } else if (isTwoPair(hand1)) {
                    numTwoPair++;
                    result = "Two Pair";
                } else if (isOnePair(hand1)) {
                    numOnePair++;
                    result = "One Pair";
                } else {
                    numHighCard++;
                    result = "High Card";
                }
                if (displayDetails) {
                    System.out.print(Arrays.toString(hand1));
                    System.out.println(" - " + result);
				}
				handCount++;
			} while (handCount < numHands && deck.numCards() > 5);
		}

		displayHandOdds(numHands, numStraightFlush, numQuads, numFullBoat,
				numFlush, numStraight, numTrips, numTwoPair, numOnePair,
				numHighCard);

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
