package Views;

import java.awt.image.BufferedImage;

/**
 * Created by Sander on 24-11-2016.
 */
public class SpriteSheet {
    public BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage ss){
        this.spriteSheet = ss;
    }

    public BufferedImage grabSprite(int x, int y, int width, int height){
        BufferedImage sprite = spriteSheet.getSubimage(x,y,width, height);
        return sprite;
    }
}
