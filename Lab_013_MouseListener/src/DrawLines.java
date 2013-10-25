import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JApplet;

public class DrawLines extends JApplet implements MouseListener {
	
	int clickCount = 0;
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
		
	public void init(){
		
		setLayout(null);
		setSize(400,400);
		addMouseListener(this);
		
	}
	
	public void paint(Graphics g){
		Random gen = new Random();
		if (clickCount==2){
			Color c = new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256));
			g.setColor (c);
			g.drawLine(x1, y1, x2, y2);
			clickCount = 0;
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		int x = e.getX();
		int y = e.getY();
		if (clickCount == 0) {
			x1 = x;
			y1 = y;
			clickCount++;
		} else if (clickCount == 1) {
			x2 = x;
			y2 = y;
			clickCount++;
		}
		repaint();
		e.consume();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	
}
