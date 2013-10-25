import javax.swing.JApplet;
import java.awt.*;
import java.net.URL;

public class Images extends JApplet {

    private Image one;

    public void init() {
        setSize(400, 400);
        one = getImage(getCodeBase(), "dice1.gif");
    }

    public void paint(Graphics g) {
        g.drawImage(one, 18, 29, 36, 36, this);
    }
}
