import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomDice extends JApplet implements ActionListener{
	Image[] dice = new Image[6];
		
	Button rollButton = new Button("Roll 'Em!");
	int die1 = 0;
	int die2 = 0;
	
	public void init(){
		setSize(400,400);
		setLayout(null);
		
		rollButton.setBounds(80, 180, 100, 20);
		add (rollButton);
		rollButton.addActionListener(this);
		
		getDice();		
		
	}
	 public void paint(Graphics g) {
	        super.paint(g);
	        
	        g.drawImage(dice[die1], 95, 50, 32, 32, this);
	        g.drawImage(dice[die2], 140, 50, 32, 32, this);
	        
	        Font f = new Font(Font.SERIF, Font.PLAIN, 28);
			g.setFont(f);
	        
	        g.drawString("Your total is " + (die1+die2+2), 50, 140);
	 }

	private void getDice() {
		for (int i = 0; i < 6; i++) {
			String die = "";
			dice[i] = getImage(getCodeBase(), "dice" + (i + 1) + ".gif");

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random gen = new Random();
		die1 = gen.nextInt(6);
		die2 = gen.nextInt(6);
		
		repaint();
	
	}


}
