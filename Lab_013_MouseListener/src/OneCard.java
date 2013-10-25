import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JApplet;

public class OneCard extends JApplet implements ActionListener, MouseListener {

	Button dealButton = new Button("Deal");
	Button showButton = new Button("Show");
	Image[] cards = new Image[52];

	Image back;
	boolean show = false;
	int cardNum = 0;

	public void init() {
		setSize(300, 200);
		setLayout(null);
		getCards();
		addMouseListener(this);
		dealButton.setBounds(110, 90, 100, 20);
		add(dealButton);
		dealButton.addActionListener(this);
	}

	public void getCards() {
		back = getImage(getCodeBase(), "b1fv.gif");
		for (int i = 0; i < 52; i++) {
			char suit = "cdhs".charAt((i / 13));
			char val = "123456789tjqk".charAt((i % 13));
			String card = "" + suit + val;
			cards[i] = getImage(getCodeBase(), card + ".gif");
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (show) {
			g.drawImage(cards[cardNum], 20, 50, 71, 96, this);
		} else {
			g.drawImage(back, 20, 50, 71, 96, this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x > 20 && x < (20 + 71) && y > 50 && y < (50 + 96)) {
			show = !show;

		}
		repaint();
		e.consume();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dealButton) {
			Random gen = new Random();
			cardNum = gen.nextInt(52);
			repaint();
		}

	}

}
