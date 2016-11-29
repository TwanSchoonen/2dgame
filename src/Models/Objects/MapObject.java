package Models.Objects;

import java.awt.*;

/**
 * Created by twan on 24-11-2016.
 */

//Super class for all map objects
public abstract class MapObject {
    private int x;
    private int y;
    private int HEIGHT;
    private int WIDTH;
    private String graphicPath;

    public MapObject(int x, int y, int HEIGHT, int WIDTH, String graphicPath) {
        this.x = x;
        this.y = y;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        this.graphicPath = graphicPath;
    }

    public String getGraphicPath() {
        return graphicPath;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
}
