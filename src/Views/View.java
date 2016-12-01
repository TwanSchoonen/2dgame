package Views;

import MainClasses.GameFrame;
import Models.Objects.MapObject;
import Models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by twan on 22-11-2016.
 */
public class View extends JPanel{

    private float interpolation;
    private Player player;
    private Image background;

    BufferedImage spriteSheet = null;
    SpriteSheet ss;
    BufferedImage playerSprite;
    private double ver;
    private double hor;
    int playerSpriteX = 0;
    int playerSpriteY = 0;


    public View (){

        this.setSize(GameFrame.GAMEHEIGHT,GameFrame.GAMEWIDTH);

        setVisible(true);

        setBackground(new Color(96, 3, 69));


        this.background = null;

        try {
            spriteSheet = ImageIO.read(ClassLoader.getSystemResource("\\Recources\\Character\\CharSheet.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        ss = new SpriteSheet(spriteSheet);

    }

    public void linkPlayer(Player player) {
        this.player = player;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw background
        if(player.getCurrentLevel().isNewLevel()) {
            try {
                background = ImageIO.read(ClassLoader.getSystemResource(player.getCurrentLevel().getBackgroundPath()));
                player.getCurrentLevel().setNewLevel(false);
            } catch (IOException e) {
                System.out.println("backgroundloadingfailed");
                e.printStackTrace();
            }
        }
        if(background!=null) {
            g.drawImage(background, 0, 0, GameFrame.GAMEWIDTH, GameFrame.GAMEHEIGHT, null);
        }
        //draw player
        drawPlayer(g);

        //draw current level
            //draw level objects
            for(MapObject o : player.getCurrentLevel().getMapObjects()){
                //draws the image
                int drawX = o.getX() - o.getWIDTH()/2;
                int drawY = o.getY() - o.getHEIGHT()/2;
                g.drawImage(o.getImage(), drawX, drawY,o.getHEIGHT(), o.getWIDTH(), null);
                //draw boundary rectangles
                g.drawRect(drawX,drawY,o.getWIDTH(),o.getHEIGHT());
            }



    }

    private void drawPlayer(Graphics g){

        int drawX = (int) ((player.getX() - player.getLastX()) * interpolation + player.getLastX() - player.getCHARWIDTH()/2);
        int drawY = (int) ((player.getY() - player.getLastY()) * interpolation + player.getLastY() - player.getCHARHEIGHT()/2);

        //draw the player rectangle
        g.drawRect(drawX,drawY,player.getCHARWIDTH(),player.getCHARHEIGHT());

        //player movement
        ver = player.getVertMovement();
        hor = player.getHoriMovement();
        if(ver<0){
            playerSpriteY = 138;
        }
        if(ver>0){
            playerSpriteY = 552;
        }
        if(hor<0){
            playerSpriteY = 0;
        }
        if(hor>0){
            playerSpriteY = 966;
        }
        playerSprite = ss.grabSprite(playerSpriteX,playerSpriteY,132,132);
        g.drawImage(playerSprite,drawX,drawY,player.getCHARWIDTH(),player.getCHARHEIGHT(),null);
    }

    public void setInterpolation(float interp)
    {
        interpolation = interp;
    }

}
