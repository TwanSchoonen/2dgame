package Models.levels;

import Models.Objects.MapObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by twan on 24-11-2016.
 */

//Super class for all levels
public abstract class Level {

    private ArrayList<MapObject> mapObjects;

    private Image background;

    public abstract boolean CheckBoundaries();

    public abstract Level getNextLevel();

}
