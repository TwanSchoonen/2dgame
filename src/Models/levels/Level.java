package Models.levels;

import MainClasses.GameFrame;
import Models.Objects.MapObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by twan on 24-11-2016.
 */


//Super class for all levels
public abstract class Level{

    private ArrayList<MapObject> mapObjects;

    private String backgroundPath;

    private boolean newLevel = false;

    public abstract Level getNextLevel();

    public Level(){
        this("\\Recources\\grass_template2.jpg");
    }

    public Level(String backgroundPath) {
        this.backgroundPath = backgroundPath;
        this.mapObjects = new ArrayList<>();
        this.newLevel = true;
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

    public boolean boundaries(double x, double y){
        return ((x > 0) && (x < GameFrame.GAMEWIDTH) && (y > 0) && (y < GameFrame.GAMEHEIGHT));
    }

    public boolean isNewLevel() {
        return newLevel;
    }

    public void setNewLevel(boolean newLevel) {
        this.newLevel = newLevel;
    }
}
