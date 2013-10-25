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
    Image[] tiles;

    // *******************************************************
    public void init() {
        setSize(380, 460);
        setLayout(null);
        setBackground(Color.gray.darker());

        /*
         * Write code here that loads images for the puzzle. Only load images
         * int cells 0 through 7. Cell 8 should be left null (i.e., empty).
         */
        // <INSERT CODE HERE>>


        

        /*
         * Write code here that adds a mouse listener for the applet.
         */
        // <INSERT CODE HERE>>


        

        /*
         * Write code here that sets up the start button. This button should be
         * enabled when the applet begins
         */
        // <INSERT CODE HERE>>


        

        /*
         * Write code here that sets up the start button. This button should be
         * disabled when the applet begins
         */
        // <INSERT CODE HERE>>


        

        /*
         * Write code here that copies startBoard into board. Use the
         * Arrays.copyOf() method.
         */
        // <INSERT CODE HERE>>


        
    }

    // *******************************************************
    public void paint(Graphics g) {
        super.paint(g);
        // Clear the applet
        g.clearRect(0, 0, 380, 480);

        /*
         * Write code here that creates a background for the puzzle area (not
         * the whole applet, just the puzzle area) using a color other than the
         * background color.
         */
        // <INSERT CODE HERE>>


        /*
         * Write code here that draws the puzzle tiles. Do not leave any space
         * between the images. The first tile has been done for you
         */
        // <INSERT CODE HERE>>
        g.drawImage(tiles[board[0]], 40, 40, 100, 100, this);


        /*
         * Write code here that displays the current move count. Also display a
         * congratulatory message if the puzzle "isDone"
         */
        // <INSERT CODE HERE>>

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
        // <INSERT CODE HERE>>


        
        /*
         * Write code here to do the following when the resetButton is clicked:
         * (1) copy startBoard into board. Use the Arrays.copyOf() method. (2)
         * reset emptyPos = 8 (3) set both isDone and canMove to to false. (3)
         * set moveCount = 0 (5) enable the start button and disable the reset
         * button.
         */
        // <INSERT CODE HERE>>

        

        /*
         * Don't forget to call the repaint method!
         */
        // <INSERT CODE HERE>>
        
        
        
    }

    // *******************************************************
    @Override
    public void mouseClicked(MouseEvent e) {

        if (canMove) {
            int x = e.getX();
            int y = e.getY();
            int row = -1;
            int col = -1;

            // If the puzzle area was clicked, do the four
            // steps below:
            if (x >= 40 & x <= 339 & y >= 40 & y <= 339) {

                /*
                 * (1) Write code here to determine exactly which tile (from 0
                 * to 8) was clicked and store that value in a variable called
                 * posClicked.
                 */
                // <INSERT CODE HERE>>
                //int posClicked = ???

                
                
                /*
                 * (2) call the moveTo method with posClicked as an argument.
                 */
                // <INSERT CODE HERE>>

                

                /*
                 * (3) compare the contents of the board and startBoard arrays.
                 * If they are the same, the puzzle is done... set isDone to
                 * true and canMove to false.
                 */
                // <INSERT CODE HERE>>


                
                

                /*
                 * (4) call the repaint method!
                 */
                // <INSERT CODE HERE>>


                
            }
        }
        e.consume();
    }

    // *******************************************************
    public void moveTo(int fromPos) {
        System.out.println("clicked: " + fromPos);
        System.out.println(Arrays.toString(board));

        /*
         * Determine whether or not a valid move is possible when the tile at
         * fromPos is clicked. For example, if fromPos = 3, emptyPos needs to be
         * 0, 4, or 6 in order for a move to be valid. Indicate whether or not
         * the requested move is allowable by setting the boolean variable
         * validMove to true or false.
         */
        boolean validMove = false;
        // <INSERT CODE HERE>>


        
        if (validMove) {
            /*
             * Write code here to perform the following if validMove is true:
             * (1) swap the values in the board array at positions emptyPos and
             * fromPos. (2) set emptyPos equal to fromPos. (3) add 1 to
             * moveCount.
             */
            // <INSERT CODE HERE>>

            
            
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