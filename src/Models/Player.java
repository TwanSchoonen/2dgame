package Models;

import Models.levels.Level;
import Models.levels.Level0;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {

    //Constants of the player:
    //Used for the speed of the movements
    private final double MOVEMENTINCREASE = 3;
    public final int CHARWIDTH = 10;
    public final int CHARHEIGHT = 10;
    private static int GAMEWIDTH;
    private static int GAMEHEIGHT;

    //Boolean used for movement
    private boolean moveDown;
    private boolean moveUp;
    private boolean moveLeft;
    private boolean moveRight;

    //coordinates of the player
    private double x;
    private double lastX;
    private double y;
    private double lastY;

    private Level currentLevel;


    public Player(int GAMEWIDTH, int GAMEHEIGHT) {
        this.GAMEWIDTH = GAMEWIDTH;
        this.GAMEHEIGHT = GAMEHEIGHT;
        initPlayer();
    }

    private void initPlayer(){
        x = GAMEWIDTH/2;
        y = GAMEHEIGHT/2;
        lastX = GAMEWIDTH/2;
        lastY = GAMEHEIGHT/2;
        this.currentLevel = new Level0();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void updateMovement(){
        if(moveDown){
            lastY = y;
            this.y+=MOVEMENTINCREASE;
        }
        if(moveUp){
            lastY = y;
            this.y-=MOVEMENTINCREASE;
        }
        if(moveLeft){
            lastX = x;
            this.x-=MOVEMENTINCREASE;
        }
        if(moveRight){
            lastX = x;
            this.x+=MOVEMENTINCREASE;
        }
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public double getLastX() {
        return lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void resetPlayer() {
       initPlayer();
    }

}
