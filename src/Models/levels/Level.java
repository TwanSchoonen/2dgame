package Models.levels;

import MainClasses.GameFrame;
import Models.Objects.MapObject;

import java.awt.*;
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

    public ArrayList<MapObject> getMapObjects(){
        return new ArrayList<>(mapObjects);
    }

    public void addMapObject(MapObject o){
        mapObjects.add(o);
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }
}
