package Models.levels;

import MainClasses.GameFrame;
import Models.Objects.MapObject;
import Models.Player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by twan on 24-11-2016.
 */


//Super class for all levels
public abstract class Level {

    private ArrayList<MapObject> mapObjects;

    private String backgroundPath;

    public abstract boolean CheckBoundaries();

    public abstract Level getNextLevel();


    public Level(String backgroundPath) {
        this.backgroundPath = backgroundPath;
        this.mapObjects = new ArrayList<>();
    }


    public ArrayList<MapObject> getMapObjects() {
        return new ArrayList<>(mapObjects);
    }

    public void addMapObject(MapObject o) {
        mapObjects.add(o);
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public boolean boundaries(Rectangle playerRect) {
        boolean b = true;
        for (MapObject m : mapObjects) {
            if (m.getRectangle().intersects(playerRect)) {
                b = false;
            }
        }
        Rectangle levelRectangle = new Rectangle(0, 0, GameFrame.GAMEWIDTH, GameFrame.GAMEHEIGHT);
        if (levelRectangle.contains(playerRect)) {
            b = true;
        }
        else {
                b = false;
            }
        return b;
    }
}
