import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullseye extends JApplet {
	
	public void paint (Graphics g){
		super.paint(g);
		
		g.setColor(Color.black);
		g.fillOval(60, 40, 220, 220);
		g.setColor(Color.red);
		g.fillOval(80, 60, 180, 180);
		g.setColor(Color.black);
		g.fillOval(100, 80, 140, 140);
		g.setColor(Color.red);
		g.fillOval(120, 100, 100, 100);
		g.setColor(Color.black);
		g.fillOval(140, 120, 60, 60);
		g.setColor(Color.red);
		g.fillOval(160, 140, 20, 20);
	}

}
