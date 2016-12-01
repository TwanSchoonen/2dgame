package Models;

import MainClasses.GameFrame;
import Models.levels.Level;
import Models.levels.Level0;

import java.awt.*;

/**
 * Created by twan on 22-11-2016.
 */
public class Player {


    private final double SPEED = 3;
    private final int CHARWIDTH = 50;
    private final int CHARHEIGHT = 50;

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
    //x indicates the middle x of the player
    private double x;
    private double lastX;
    //y indicates the middle y of the player
    private double y;
    private double lastY;

    //rpg elements of the player
    private int hp;
    private int maxHP;

    //The level that the player plays in
    private Level currentLevel;


    public Player() {
        initPlayer();
    }

    private void initPlayer(){
        x = GameFrame.GAMEWIDTH/2;
        y = GameFrame.GAMEHEIGHT/2;
        lastX = GameFrame.GAMEWIDTH/2;
        lastY = GameFrame.GAMEHEIGHT/2;

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

        if (!currentLevel.objectBoundaries(getRectangle())) {
            Level temp = currentLevel.getObjectLevel();
            if(temp!=null){
                currentLevel = temp;
            }
        } else if (!currentLevel.mapBoundaries(getRectangle())){
            int direction = 0; //1 = north, 2 = east, 3 = south, 4 = west
            double newX = x;
            double newY = y;
            if(y+vertMovement<=getCHARHEIGHT()/2){
                direction = 1;
                newY=GameFrame.GAMEHEIGHT-getCHARHEIGHT()/2-2;
            } else if(x - horiMovement + getCHARWIDTH()/2>=GameFrame.GAMEWIDTH){
                direction = 2;
                newX=getCHARWIDTH()/2+2;
            } else if (y + vertMovement + getCHARHEIGHT()/2 >=GameFrame.GAMEHEIGHT){
                direction = 3;
                newY=getCHARHEIGHT()/2+2;
            } else if (x - horiMovement<=getCHARWIDTH()/2){
                direction = 4;
                newX = GameFrame.GAMEWIDTH-getCHARWIDTH()/2 - 2;
            }
            Level temp = currentLevel.getNextLevel(direction);
            if(temp!=null){
                currentLevel = temp;
                this.horiMovement = 0;
                this.vertMovement = 0;
                this.x = newX;
                this.y = newY;
            }
        } else {
            this.y += vertMovement;
            this.x -= horiMovement;
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
        return new Rectangle((int) (x-horiMovement-CHARWIDTH/2), (int) (y+vertMovement-CHARHEIGHT/2), CHARWIDTH, CHARHEIGHT);
    }

    public int getCHARWIDTH() {
        return CHARWIDTH;
    }

    public int getCHARHEIGHT() {
        return CHARHEIGHT;
    }
}