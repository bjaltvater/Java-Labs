import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CardHand extends JApplet  {
    Image[] cards = new Image[52];

    public void init() {
        setSize(400, 400);
        setLayout(null);
        getCards();
//        getCards2();
//        shuffleCards();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Random gen = new Random();
        g.drawImage(cards[0], 20, 50, 71, 96, this);
        g.drawImage(cards[1], 95, 50, 71, 96, this);
        g.drawImage(cards[2], 170, 50, 71, 96, this);
        g.drawImage(cards[3], 245, 50, 71, 96, this);
        g.drawImage(cards[4], 320, 50, 71, 96, this);
    }
     
    public void getCards() {
        cards[0] = getImage(getCodeBase(),"c1.gif");
        cards[1] = getImage(getCodeBase(),"c2.gif");
        cards[2] = getImage(getCodeBase(),"c3.gif");
        cards[3] = getImage(getCodeBase(),"c4.gif");
        cards[4] = getImage(getCodeBase(),"c5.gif");
        cards[5] = getImage(getCodeBase(),"c6.gif");
        cards[6] = getImage(getCodeBase(),"c7.gif");
        cards[7] = getImage(getCodeBase(),"c8.gif");
        cards[8] = getImage(getCodeBase(),"c9.gif");
        cards[9] = getImage(getCodeBase(),"ct.gif");
        cards[10] = getImage(getCodeBase(),"cj.gif");
        cards[11] = getImage(getCodeBase(),"cq.gif");
        cards[12] = getImage(getCodeBase(),"ck.gif");
        cards[13] = getImage(getCodeBase(),"d1.gif");
        cards[14] = getImage(getCodeBase(),"d2.gif");
        cards[15] = getImage(getCodeBase(),"d3.gif");
        cards[16] = getImage(getCodeBase(),"d4.gif");
        cards[17] = getImage(getCodeBase(),"d5.gif");
        cards[18] = getImage(getCodeBase(),"d6.gif");
        cards[19] = getImage(getCodeBase(),"d7.gif");
        cards[20] = getImage(getCodeBase(),"d8.gif");
        cards[21] = getImage(getCodeBase(),"d9.gif");
        cards[22] = getImage(getCodeBase(),"dt.gif");
        cards[23] = getImage(getCodeBase(),"dj.gif");
        cards[24] = getImage(getCodeBase(),"dq.gif");
        cards[25] = getImage(getCodeBase(),"dk.gif");
        cards[26] = getImage(getCodeBase(),"h1.gif");
        cards[27] = getImage(getCodeBase(),"h2.gif");
        cards[28] = getImage(getCodeBase(),"h3.gif");
        cards[29] = getImage(getCodeBase(),"h4.gif");
        cards[30] = getImage(getCodeBase(),"h5.gif");
        cards[31] = getImage(getCodeBase(),"h6.gif");
        cards[32] = getImage(getCodeBase(),"h7.gif");
        cards[33] = getImage(getCodeBase(),"h8.gif");
        cards[34] = getImage(getCodeBase(),"h9.gif");
        cards[35] = getImage(getCodeBase(),"ht.gif");
        cards[36] = getImage(getCodeBase(),"hj.gif");
        cards[37] = getImage(getCodeBase(),"hq.gif");
        cards[38] = getImage(getCodeBase(),"hk.gif");
        cards[39] = getImage(getCodeBase(),"s1.gif");
        cards[40] = getImage(getCodeBase(),"s2.gif");
        cards[41] = getImage(getCodeBase(),"s3.gif");
        cards[42] = getImage(getCodeBase(),"s4.gif");
        cards[43] = getImage(getCodeBase(),"s5.gif");
        cards[44] = getImage(getCodeBase(),"s6.gif");
        cards[45] = getImage(getCodeBase(),"s7.gif");
        cards[46] = getImage(getCodeBase(),"s8.gif");
        cards[47] = getImage(getCodeBase(),"s9.gif");
        cards[48] = getImage(getCodeBase(),"st.gif");
        cards[49] = getImage(getCodeBase(),"sj.gif");
        cards[50] = getImage(getCodeBase(),"sq.gif");
        cards[51] = getImage(getCodeBase(),"sk.gif");
    }

    public void getCards2() {
        for (int i = 0; i < 52; i++) {
            char suit = "cdhs".charAt((i / 13));
            char val = "123456789tjqk".charAt((i % 13));
            String card = "" + suit + val;
            cards[i] = getImage(getCodeBase(), card + ".gif");
        }
    }
}
