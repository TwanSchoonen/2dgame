package Models.levels;

/**
 * Created by twan on 24-11-2016.
 */
public class Level1 extends Level{

    public Level1(){
        super("\\Recources\\Ocean.png");
    }

    public Level getNextLevel(int direction) {
        if (direction == 1){
            return new Level0();
        }
        return null;
    }
}
