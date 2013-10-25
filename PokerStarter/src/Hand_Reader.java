import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class Hand_Reader extends JApplet implements ActionListener {
	private Random RandGen;
	public static Image[] Cards = new Image[52];
	public static Image[] cardBack = new Image[1];
	int[] hand;
	static Card[] newDeck = new Card[52];

	static boolean hideCards = true;
	
	Button dealButton = new Button("Deal");

	static String result = "";

	public void init() {

		setSize(400, 300);
		setLayout(null);

		dealButton.setBounds(150, 220, 100, 20);
		add(dealButton);
		dealButton.addActionListener(this);

		loadCardImages();

	}

	public void paint(Graphics g) {
		super.paint(g);
		int xpos = 15;
		Font f = new Font(Font.SERIF, Font.PLAIN, 20);
		g.setFont(f);

		g.drawString("Click \"DEAL\" to determine your hand", 50, 200);

		if (hideCards) {
			for (int i = 0; i < 5; i++) {
				g.drawImage(cardBack[0], xpos, 50, 71, 96, this);
				xpos = xpos + 75;

			}
		} else {
			for (int i = 0; i < 5; i++) {
				g.drawImage(Cards[i], xpos, 50, 71, 96, this);
				xpos = xpos + 75;
				g.drawString("Your hand is " + result, 100, 175);
			}

			
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

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		hideCards = false;
		shuffleCards();
		readHand();

		repaint();

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

	private void readHand() {
		Card[] hand1 = new Card[5];
		hand1 = Arrays.copyOf(newDeck, 5);
		PokerHands.computeHandOdds(hand1);

		System.out.println(Arrays.toString(hand1));

	}

}
