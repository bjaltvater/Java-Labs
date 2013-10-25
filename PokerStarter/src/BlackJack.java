import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class BlackJack extends JApplet implements ActionListener {
	private Random RandGen;
	public static Image[] Cards = new Image[52];
	public static Image[] cardBack = new Image[1];
	public static Image[] playerHandImage = new Image[10];
	public static Image[] dealerHandImage = new Image[10];
	static Card[] newDeck = new Card[52];
	static Card[] playerHand = new Card[10];
	static Card[] dealerHand = new Card[10];

	public int yourScore = 0;
	public int dealerScore = 0;
	public int hitCounter = 0;

	static boolean hideCards = true;
	static boolean Stay = false;

	Button dealButton = new Button("Deal");
	Button stayButton = new Button("Stay");
	Button hitButton = new Button("Hit");

	static String result = "";

	public void init() {

		setSize(400, 400);
		setLayout(null);

		dealButton.setBounds(150, 340, 100, 20);
		add(dealButton);
		dealButton.addActionListener(this);

		stayButton.setBounds(210, 310, 100, 20);
		add(stayButton);
		stayButton.addActionListener(this);

		hitButton.setBounds(90, 310, 100, 20);
		add(hitButton);
		hitButton.addActionListener(this);

		loadCardImages();
		hitButton.disable();
		stayButton.disable();

		result = "Click \"DEAL\" to Start";

	}

	public void paint(Graphics g) {
		super.paint(g);
		int playerXpos = 130;
		int dealerXpos = 130;
		Font f = new Font(Font.SERIF, Font.PLAIN, 20);
		g.setFont(f);

		if (hideCards) {

			for (int i = 0; i < 2; i++) {
				g.drawImage(cardBack[0], playerXpos, 190, 71, 96, this);
				playerXpos = playerXpos + 35;
			}
			for (int i = 0; i < 2; i++) {
				g.drawImage(cardBack[0], dealerXpos, 50, 71, 96, this);
				dealerXpos = dealerXpos + 35;

			}
			g.drawString(result, 120, 390);
		} else {

			for (int i = 0; i < 5; i++) {
				g.drawImage(playerHandImage[i], playerXpos, 190, 71, 96, this);
				playerXpos = playerXpos + 35;
			}
			for (int i = 0; i < 5; i++) {
				g.drawImage(dealerHandImage[i], dealerXpos, 50, 71, 96, this);
				dealerXpos = dealerXpos + 35;
				g.drawString(result, 120, 390);

			}
			if (Stay) {
				g.drawImage(cardBack[0], 130, 50, 71, 96, this);
				g.drawImage(dealerHandImage[1], 165, 50, 71, 96, this);
				g.drawString(result, 120, 390);

			}

			// g.drawString("Your hand is " + result, 100, 175);
		}
	}

	private void loadCardImages() {
		cardBack[0] = getImage(getCodeBase(), "b2fv.gif");

		String suits = "CDHS";
		String values = "23456789TJQKA";

		for (int i = 0; i < newDeck.length; i++) {
			char suit = suits.charAt((i / 13));
			char value = values.charAt((i % 13));
			String card = "" + suit + value;
			Cards[i] = getImage(getCodeBase(), card + ".gif");
			newDeck[i] = new Card(suit, value);

			if (newDeck[i].worth > 10) {
				newDeck[i].worth = 10;
			}
			if (newDeck[i].value == 'A') {
				newDeck[i].worth = 11;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dealButton) {
			hideCards = false;
			Stay = true;
			hitCounter = 0;
			shuffleCards();
			startDeal();
			changeAce();

			dealButton.setEnabled(false);
			hitButton.setEnabled(true);
			stayButton.setEnabled(true);

			result = " Your score is " + yourScore + " Hit or Stay";

			repaint();
		}
		if (e.getSource() == hitButton) {
			takeCard();
			changeAce();
			result = " Your score is " + yourScore + " Hit or Stay";
			repaint();

		}
		if (e.getSource() == stayButton) {
			Stay = false;
			stayButton.setEnabled(false);
			hitButton.setEnabled(false);
			dealButton.setEnabled(true);
			result = "Click \"DEAL\" to Start";

			repaint();
		}

	}

	private void changeAce() {
		if (yourScore > 21) {
			for (int i = 0; i < playerHand.length; i++) {
				if (playerHand[i].worth == 11) {
					playerHand[i].worth = 1;
				}
			}

		}else {
			
		}

	}

	private void takeCard() {
		if (yourScore <= 21) {
			playerHand[hitCounter + 2] = newDeck[1];
			newDeck = Arrays.copyOfRange(newDeck, 1, newDeck.length);
			playerHandImage[hitCounter +2] = Cards[1];
			yourScore = yourScore + playerHand[hitCounter + 2].worth;
			hitCounter++;

		}else {
			result =  yourScore + " Bust";
		}

	}

	private void shuffleCards() {
		RandGen = new Random();

		for (int i = 0; i < 100; i++) {
			int spot1 = RandGen.nextInt(newDeck.length);
			int spot2 = RandGen.nextInt(newDeck.length);
			Image dummy = Cards[spot1];
			Cards[spot1] = Cards[spot2];
			Cards[spot2] = dummy;

			Card dummy2 = newDeck[spot1];
			newDeck[spot1] = newDeck[spot2];
			newDeck[spot2] = dummy2;
		}

	}

	private void startDeal() {

		for (int i = 0; i < 2; i++) {
			playerHand[i] = newDeck[i];
			playerHandImage[i] = Cards[i];
			newDeck = Arrays.copyOfRange(newDeck, 1, newDeck.length);
			Cards = Arrays.copyOfRange(Cards, 1, Cards.length);
			dealerHand[i] = newDeck[i];
			dealerHandImage[i] = Cards[i];
			newDeck = Arrays.copyOfRange(newDeck, 1, newDeck.length);
			Cards = Arrays.copyOfRange(Cards, 1, Cards.length);

			yourScore = yourScore + playerHand[i].worth;
			dealerScore = dealerScore + dealerHand[i].worth;

		}

		System.out.println(Arrays.toString(dealerHand));
		System.out.println(Arrays.toString(playerHand));
		System.out.println(Arrays.toString(newDeck));

	}

}
