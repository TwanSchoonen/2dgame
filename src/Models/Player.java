package Models;

import Models.levels.Level;
import Models.levels.Level0;

import java.awt.*;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {


    private final double SPEED = 3;
    public final int CHARWIDTH = 10;
    public final int CHARHEIGHT = 10;
    private static int GAMEWIDTH;
    private static int GAMEHEIGHT;

    //Boolean used for movement
    private boolean moveDown;
    private boolean moveUp;
    private boolean vertMov;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean horiMov;

    private double vertMovement = 0;
    private double horiMovement = 0;

    //coordinates of the player
    private double x;
    private double lastX;
    private double y;
    private double lastY;

    //rpg elements of the player
    private int hp;
    private int maxHP;

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

        this.maxHP = 30;
        this.hp = 30;
        this.currentLevel = new Level0();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //called every frame to update the player movement
    public void updateMovement() {
        if (moveDown) {
            this.vertMovement = SPEED;
        }
        if (moveUp) {
            this.vertMovement = -SPEED;
        }
        if(!moveDown && !moveUp) {
            this.vertMovement = 0;
        }
        if(moveLeft){
            this.horiMovement = SPEED;
        }
        if (moveRight) {
            this.horiMovement = -SPEED;
        }
        if (!moveDown && !moveUp) {
            this.vertMovement = 0;
        }
        if (!moveLeft && !moveRight) {
            this.horiMovement = 0;
        }

        lastY = y;
        lastX = x;

        
        if (currentLevel.boundaries(getRectangle())) {
            this.y += vertMovement;
            this.x -= horiMovement;
        } else {
            currentLevel = currentLevel.getNextLevel();
            x = GAMEWIDTH / 2;
            y = GAMEHEIGHT / 2;

        }
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

    public double getVertMovement() {
        return vertMovement;
    }

    public double getHoriMovement() {
        return horiMovement;
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

    public Rectangle getRectangle() {
        return new Rectangle((int) (x-horiMovement), (int) (y+vertMovement), CHARWIDTH, CHARHEIGHT);
    }
}