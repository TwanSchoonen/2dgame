package Views;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Sander on 24-11-2016.
 */
public class BufferedImageLoader {
    public BufferedImage loadImage(String pathRelativeToThis) throws IOException{
        URL url = this.getClass().getResource(pathRelativeToThis);
        BufferedImage img = ImageIO.read(url);
        return img;
    }
}
