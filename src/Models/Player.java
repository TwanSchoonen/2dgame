package Models;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {
    
    private final double MOVEMENTINCREASE = 3;
    public final int CHARWIDTH = 10;
    public final int CHARHEIGHT = 10;

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

    public Player() {
        x = 0;
        y = 0;
        lastX = 0;
        lastY = 0;
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
}
