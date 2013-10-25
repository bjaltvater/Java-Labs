import java.util.Arrays;
import java.util.Random;

public class CardDeck {

    // fields
    private Card[] deck; // a deck of Card objects
    private Random randGen; // a Random object used by shuffleDeck

    // constructor
    public CardDeck() {
        String suits = "CDHS";
        String values = "23456789TJQKA";
        Card[] newDeck = new Card[52];
        for (int i = 0; i < newDeck.length; i++) {
            char suit = suits.charAt(i / 13);
            char value = values.charAt(i % 13);
            newDeck[i] = new Card(suit, value);
        }
        deck = newDeck;
        randGen = new Random();
    }

    // returns how many cards are remaining in the deck
    public int numCards() {
        return deck.length;
    }

    // randomly reorders the cards in the deck array
    public void shuffleDeck() {
        /*
         * Write code here that "shuffles" the deck of cards.
         */
    	
    	for (int i = 0; i < 100; i++){
    		int spot1 = randGen.nextInt(52);
    		int spot2 = randGen.nextInt(52);
    		Card dummy = deck[spot1]; 
    		deck[spot1] = deck[spot2];
    		deck[spot2]= dummy;
    		
    		
    	}
    }

    // creates an array of Card objects containing the first n Cards
    // in the deck
    public Card[] dealCards(int n) {
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    // returns the first card in the deck array. Also replaces the deck with a
    // copy of the deck without the first card.
    public Card dealCard() {
        if (deck.length == 0)
            throw new RuntimeException("out of cards");
        Card card = deck[0];
        deck = Arrays.copyOfRange(deck, 1, deck.length);
        return card;
    }

    @Override
    public String toString() {
        return Arrays.toString(deck);
    }

}
