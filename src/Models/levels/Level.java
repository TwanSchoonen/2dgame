package Models.levels;

import MainClasses.GameFrame;
import Models.Objects.MapObject;
import Models.Player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by twan on 24-11-2016.
 */


//Super class for all levels
public abstract class Level{

    private ArrayList<MapObject> mapObjects;

    private String backgroundPath;

    private Level objectLevel;

    private boolean newLevel = false;

    public abstract Level getNextLevel(int direction);

    public Level(String backgroundPath) {
        this.backgroundPath = backgroundPath;
        this.mapObjects = new ArrayList<>();
        this.newLevel = true;
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

    public boolean objectBoundaries(Rectangle playerRect) {
        boolean b = true;
        for (MapObject o : mapObjects) {
            if (o.getRectangle().intersects(playerRect)) {
                objectLevel = o.getObjectLevel();
                b = false;
            }
        }
        return b;
    }

    public boolean mapBoundaries(Rectangle playerRect){
        boolean b = true;
        Rectangle levelRectangle = new Rectangle(0, 0, GameFrame.GAMEWIDTH, GameFrame.GAMEHEIGHT);
        if (!levelRectangle.contains(playerRect)) {
            b = false;
        }

        return b;
    }

    public boolean isNewLevel() {
        return newLevel;
    }

    public void setNewLevel(boolean newLevel) {
        this.newLevel = newLevel;
    }

    public Level getObjectLevel() {
        return objectLevel;
    }
}
