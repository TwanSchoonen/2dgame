package Models;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {

    private final double SPEED = 3;
    public final int CHARWIDTH = 10;
    public final int CHARHEIGHT = 10;

    //Boolean used for movement
    private boolean moveDown;
    private boolean moveUp;
    private boolean vertMov;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean horiMov;

    private double VERTMOVEMENT = 0;
    private double HORIMOVEMENT = 0;



    //coordinates of the player
    private double x;
    private double lastX;
    private double y;
    private double lastY;

    public Player() {
        x = 20;
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
        if(moveDown) {
            this.VERTMOVEMENT = SPEED;
        }
        if(moveUp){
            this.VERTMOVEMENT = -SPEED;
        }
        if(!moveDown && !moveUp) {
            this.VERTMOVEMENT = 0;
        }
        lastY = y;
        this.y+=VERTMOVEMENT;

        if(moveLeft){
            this.HORIMOVEMENT = SPEED;
        }
        if(moveRight){
            this.HORIMOVEMENT = -SPEED;
        }
        if(!moveLeft && !moveRight) {
            this.HORIMOVEMENT = 0;
        }
        lastX = x;
        this.x-=HORIMOVEMENT;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
        if(vertMov && (!moveDown)){
            this.vertMov = false;
            moveUp = true;
        }
        if(moveUp && moveDown){
            this.vertMov = true;
            moveUp = false;
        }

    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
        if(vertMov && (!moveUp)){
            this.vertMov = false;
            moveDown = true;
        }
        if(moveDown && moveUp){
            this.vertMov = true;
            moveDown = false;
        }

    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
        if(horiMov && (!moveLeft)){
            this.horiMov = false;
            moveRight = true;
        }
        if(moveRight && moveLeft){
            this.horiMov = true;
            moveRight = false;
        }
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
        if(horiMov && (!moveRight)){
            this.horiMov = false;
            moveLeft = true;
        }
        if(moveLeft && moveRight){
            this.horiMov = true;
            moveLeft = false;
        }
    }

    public double getLastX() {
        return lastX;
    }

    public double getLastY() {
        return lastY;
    }
}
