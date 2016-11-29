package Models.levels;

import Models.Objects.MapObject;
import Models.Objects.StartHouse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by twan on 23-11-2016.
 */
//Does not work or anything
public class Level0 extends Level{

    public Level0(){
        super("\\Recources\\grass_template2.jpg");
        MapObject o = new StartHouse(100,100);
        this.addMapObject(o);
    }

    public Level getNextLevel() {
        return new Level1();
    }
}
