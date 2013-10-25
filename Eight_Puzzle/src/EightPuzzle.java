import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

public class EightPuzzle extends JApplet implements ActionListener,
		MouseListener {

	// Variables declared at the class level can be
	// seen by all of the methods and can be used to
	// share information.
	Random gen = new Random();
	int moveCount = 0;
	Button startButton = new Button("Start");
	Button resetButton = new Button("Reset");
	boolean isDone = false;
	boolean canMove = false;
	int emptyPos = 8;

	// The content of each cell in the board array is an
	// index into the tiles array.
	int[] board;

	// The startBoard array has two purposes:
	// 1) it is used to reset the board array and
	// 2) the board and startBoard arrays can be compared to
	// each other to test if the puzzle has been completed.
	int[] startBoard = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

	// The tiles array contains the images that make up the
	// puzzle. The image at index 8 should always be null.
	Image[] tiles = new Image[9];

	// *******************************************************
	public void init() {
		setSize(380, 460);
		setBackground(Color.gray.darker());
		setLayout(null);
		getTiles();

		addMouseListener(this);

		startButton.setBounds(35, 390, 100, 35);
		add(startButton);
		startButton.addActionListener(this);

		resetButton.setBounds(155, 390, 100, 35);
		add(resetButton);
		resetButton.disable();
		resetButton.addActionListener(this);

		/*
		 * Write code here that copies startBoard into board. Use the
		 * Arrays.copyOf() method.
		 */
		board = Arrays.copyOf(startBoard, 9);

	}

	public void getTiles() {
		for (int i = 0; i < 8; i++) {
			tiles[i] = getImage(getCodeBase(), ("SunsetPic" + i + ".jpg"));
		}

		tiles[8] = null;

	}

	// *******************************************************
	public void paint(Graphics g) {
		super.paint(g);
		// Clear the applet
		g.clearRect(0, 0, 380, 480);
		g.setColor(Color.white);
		g.fillRect(35, 35, 310, 310);

		g.drawImage(tiles[board[0]], 40, 40, 100, 100, this);
		g.drawImage(tiles[board[1]], 140, 40, 100, 100, this);
		g.drawImage(tiles[board[2]], 240, 40, 100, 100, this);
		g.drawImage(tiles[board[3]], 40, 140, 100, 100, this);
		g.drawImage(tiles[board[4]], 140, 140, 100, 100, this);
		g.drawImage(tiles[board[5]], 240, 140, 100, 100, this);
		g.drawImage(tiles[board[6]], 40, 240, 100, 100, this);
		g.drawImage(tiles[board[7]], 140, 240, 100, 100, this);
		g.drawImage(tiles[board[8]], 240, 240, 100, 100, this);

		/*
		 * Write code here that displays the current move count. Also display a
		 * congratulatory message if the puzzle "isDone"
		 */
		g.setColor(Color.yellow);
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 32);
		g.setFont(f);
		g.drawString("Move Count: " + moveCount, 35, 380);

		if (isDone) {
			g.drawString("Congrats you WIN!", 35, 453);
		}

	}

	// *******************************************************
	public void actionPerformed(ActionEvent e) {
		/*
		 * Write code here to do the following if the startButton is clicked:
		 * (1) call the moveTo method a great many times (e.g., 5000) to mix up
		 * the puzzle tiles; specify a random number between 0-8 as the argument
		 * for moveTo. (2) set isDone to false. (3) set canMove to true. (4) set
		 * moveCount = 0 (5) enable the reset button and disable the start
		 * button.
		 */
		if (e.getSource() == startButton) {
			startButton.disable();
			resetButton.enable();
			moveCount = 0;
			canMove = true;
			isDone = false;

			for (int i = 0; i < 5000; i++) {
				moveTo(gen.nextInt(9));

			}
			moveCount = 0;

		}

		/*
		 * Write code here to do the following when the resetButton is clicked:
		 * (1) copy startBoard into board. Use the Arrays.copyOf() method. (2)
		 * reset emptyPos = 8 (3) set both isDone and canMove to to false. (3)
		 * set moveCount = 0 (5) enable the start button and disable the reset
		 * button.
		 */

		if (e.getSource() == resetButton) {
			startButton.enable();
			resetButton.disable();
			moveCount = 0;
			canMove = false;
			isDone = false;
			board = Arrays.copyOf(startBoard, 9);
		}
		repaint();
	}

	// *******************************************************
	@Override
	public void mouseClicked(MouseEvent e) {

		if (canMove) {
			int x = e.getX();
			int y = e.getY();
			// int row = -1;
			// int col = -1;

			// If the puzzle area was clicked, do the four
			// steps below:
			if (x >= 40 & x <= 339 & y >= 40 & y <= 339) {

				/*
				 * (1) Write code here to determine exactly which tile (from 0
				 * to 8) was clicked and store that value in a variable called
				 * posClicked.
				 */
				int posClicked = 0;
				if (x >= 40 & x <= 139 & y >= 40 & y <= 139) {
					posClicked = 0;
				} else if (x >= 140 & x <= 239 & y >= 40 & y <= 139) {
					posClicked = 1;
				} else if (x >= 240 & x <= 339 & y >= 40 & y <= 139) {
					posClicked = 2;
				} else if (x >= 40 & x <= 139 & y >= 140 & y <= 239) {
					posClicked = 3;
				} else if (x >= 140 & x <= 239 & y >= 140 & y <= 239) {
					posClicked = 4;
				} else if (x >= 240 & x <= 339 & y >= 140 & y <= 239) {
					posClicked = 5;
				} else if (x >= 40 & x <= 139 & y >= 240 & y <= 339) {
					posClicked = 6;
				} else if (x >= 140 & x <= 239 & y >= 240 & y <= 339) {
					posClicked = 7;
				} else if (x >= 240 & x <= 339 & y >= 240 & y <= 339) {
					posClicked = 8;
				}
				/*
				 * (2) call the moveTo method with posClicked as an argument.
				 */

				moveTo(posClicked);

				/*
				 * (3) compare the contents of the board and startBoard arrays.
				 * If they are the same, the puzzle is done... set isDone to
				 * true and canMove to false.
				 */
				int counter = 0;
				for (int i = 0; i < 9; i++) {
					if (board[i] == startBoard[i]) {
						counter++;
						if (counter == 9) {
							isDone = true;
							canMove = false;
						}

					} else {
						counter = 0;

					}

				}
				repaint();
			}
		}
		e.consume();
	}

	// *******************************************************
	public void moveTo(int fromPos) {
		// System.out.println("clicked: " + fromPos);
		// System.out.println(Arrays.toString(board));

		/*
		 * Determine whether or not a valid move is possible when the tile at
		 * fromPos is clicked. For example, if fromPos = 3, emptyPos needs to be
		 * 0, 4, or 6 in order for a move to be valid. Indicate whether or not
		 * the requested move is allowable by setting the boolean variable
		 * validMove to true or false.
		 */
		boolean validMove = false;
		if (fromPos == 0 && (board[1] == emptyPos || board[3] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 1
				&& (board[0] == emptyPos || board[2] == emptyPos || board[4] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 2
				&& (board[1] == emptyPos || board[5] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 3
				&& (board[0] == emptyPos || board[4] == emptyPos || board[6] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 4
				&& (board[1] == emptyPos || board[3] == emptyPos
						|| board[5] == emptyPos || board[7] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 5
				&& (board[2] == emptyPos || board[4] == emptyPos || board[8] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 6
				&& (board[3] == emptyPos || board[7] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 7
				&& (board[4] == emptyPos || board[6] == emptyPos || board[8] == emptyPos)) {
			validMove = true;
		} else if (fromPos == 8
				&& (board[5] == emptyPos || board[7] == emptyPos)) {
			validMove = true;
		}

		if (validMove) {
			/*
			 * Write code here to perform the following if validMove is true:
			 * (1) swap the values in the board array at positions emptyPos and
			 * fromPos. (2) set emptyPos equal to fromPos. (3) add 1 to
			 * moveCount.
			 */

			for (int i = 0; i < board.length; i++) {

				if (board[i] == 8) {
					int spot1 = board[fromPos];
					board[fromPos] = board[i];
					board[i] = spot1;
					i = board.length;
				}

			}

			moveCount++;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		 * This method has to be included for all applets that are
		 * MouseListeners... However, we are not using it for EightPuzzle, so
		 * you can ignore it.
		 */
	}

	@Override
	public void mouseExited(MouseEvent e) {
		/*
		 * This method has to be included for all applets that are
		 * MouseListeners... However, we are not using it for EightPuzzle, so
		 * you can ignore it.
		 */
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*
		 * This method has to be included for all applets that are
		 * MouseListeners... However, we are not using it for EightPuzzle, so
		 * you can ignore it.
		 */
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*
		 * This method has to be included for all applets that are
		 * MouseListeners... However, we are not using it for EightPuzzle, so
		 * you can ignore it.
		 */
	}
}