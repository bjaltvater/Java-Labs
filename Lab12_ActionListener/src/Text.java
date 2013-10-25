import javax.swing.JApplet;
import java.awt.*;
import java.net.URL;

public class Text extends JApplet {

    public void init() {
        setSize(650, 400);
    }

    public void paint(Graphics g) {
        g.setColor(Color.green.darker().darker());
        g.drawString("An example string", 33, 30);
 
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 70);
      
        f = new Font(Font.SERIF, Font.PLAIN, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 110);

        f = new Font(Font.SERIF, Font.BOLD, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 140);

        f = new Font(Font.SERIF, Font.ITALIC, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 170);

        f = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 210);
        
        f = new Font(Font.MONOSPACED, Font.PLAIN, 32);
        g.setFont(f);        
        g.drawString("An example string", 33, 240);


    }
}
