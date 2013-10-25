import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlyButtons extends JApplet implements ActionListener {

	Button Button1 = new Button("Print Hello");
	Button Button2 = new Button("Print Goodbye");
	int buttonPressed = 0;

	public void init() {
		setSize(400, 400);
		setLayout(null);

		Button1.setBounds(20, 240, 100, 20);
		add(Button1);
		Button1.addActionListener(this);

		Button2.setBounds(200, 240, 100, 20);
		add(Button2);
		Button2.addActionListener(this);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green.darker().darker());
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 32);
		g.setFont(f);
		
		if (buttonPressed == 1) {
			g.drawString("Hello", 130, 300);
		}
		if (buttonPressed == 2) {
			g.drawString("Goodbye", 130, 300);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Button1) {
			buttonPressed = 1;
		}
		if (e.getSource() == Button2) {
			buttonPressed = 2;
		}

		repaint();

	}

}
