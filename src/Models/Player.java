package Models;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {
    //coordinates of the player
    private int x;
    private int y;

    public Player() {
        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updateX(int u) {
        if (!(x+u<0)){
            this.x = x+u*3;
        }
    }

    public void updateY(int u) {
        if (!(y+u<0)){
            this.y = y+u*3;
        }
    }
}
