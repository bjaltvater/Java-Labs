import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OneToNine extends Component {

    public static void main(String[] args) {
        new OneToNine().run();
    }

    private void processImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        System.out.println("width, height: " + w + ", " + h);

        int[][] pixels = new int[w][h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = image.getRGB(x, y);
                pixels[x][y] = pixel;
            }
        }
        int imageType = image.getType();
        createTile(pixels, imageType, 0, 0, 0);
        createTile(pixels, imageType, 0, 100, 1);
        createTile(pixels, imageType, 0, 200, 2);
        createTile(pixels, imageType, 100, 0, 3);
        createTile(pixels, imageType, 100, 100, 4);
        createTile(pixels, imageType, 100, 200, 5);
        createTile(pixels, imageType, 200, 0, 6);
        createTile(pixels, imageType, 200, 100, 7);
        createTile(pixels, imageType, 200, 200, 8);
    }

    private void createTile(int[][] pixels, int imageType, int yOffset, int xOffset,
            int tileNum) {
        BufferedImage img = new BufferedImage(100, 100, imageType);
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                int pixel = pixels[x + xOffset][y + yOffset];
                img.setRGB(x, y, pixel);
            }
        }
        try {
            System.out.println("creating: " + filePrefix + tileNum + ".jpg");
            ImageIO.write(img, "jpg", new File(filePrefix + tileNum + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String filePrefix = "labrador";
    public void run() {
        try {
            // read in an image using the ImageIO class
            BufferedImage image = ImageIO.read(new File("labrador.jpg"));
            processImage(image);
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
