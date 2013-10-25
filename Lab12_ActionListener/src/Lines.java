import javax.swing.JApplet;
import java.awt.*;
import java.util.Random;

public class Lines extends JApplet {

    public void init() {
        setBackground(Color.BLACK);
        setSize(400, 400);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, 400, 400);
        for (int i = 0; i < 300; i++) {
            Random gen = new Random();
            Color c1 = new Color(gen.nextInt(256), gen.nextInt(256),
                    gen.nextInt(256));
            g.setColor(c1);
            g.drawLine(gen.nextInt(400), gen.nextInt(400), gen.nextInt(400),
                    gen.nextInt(400));
        }
    }
}
