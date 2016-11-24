package Models.levels;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by twan on 23-11-2016.
 */
//Does not work or anything
public class Level0 extends Level{

    public Level0(){
        this.setBackgroundPath("\\Recources\\grass_template2.jpg");
    }

    public boolean CheckBoundaries() {
        return false;
    }

    public Level getNextLevel() {
        return null;
    }
}
