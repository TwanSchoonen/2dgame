package Models;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {
    
    private final double MOVEMENTINCREASE = 0.00001;

    //Boolean used for movement
    private boolean moveDown;
    private boolean moveUp;
    private boolean moveLeft;
    private boolean moveRight;


    //coordinates of the player
    private double x;
    private double y;

    public Player() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void updateMovement(){
        if(moveDown){
            this.y+=MOVEMENTINCREASE;
        }
        if(moveUp){
            this.y-=MOVEMENTINCREASE;
        }
        if(moveLeft){
            this.x-=MOVEMENTINCREASE;
        }
        if(moveRight){
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
}
