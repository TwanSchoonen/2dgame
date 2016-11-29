package Views;

import Models.Objects.MapObject;
import Models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by twan on 22-11-2016.
 */
public class View extends JPanel{

    private float interpolation;
    private Player player;
    private int WIDTH;
    private int HEIGHT;
    private Image background;

    public View (int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        setSize(WIDTH,HEIGHT); //Set panel size
        setVisible(true);
        setBackground(new Color(96, 3, 69));
        this.background = null;
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
            g.drawImage(background, 0, 0, null);
        }
        //draw current level
        try {
            //draw level objects
//            for(MapObject o : player.getCurrentLevel().getMapObjects()){
//                Image mapObject = ImageIO.read( ClassLoader.getSystemResource(o.getGraphicPath()) );
//                g.drawImage(mapObject, o.getX(), o.getY(), null);
//            }
//
//            //draw player
            int drawX = (int) ((player.getX() - player.getLastX()) * interpolation + player.getLastX() - player.CHARWIDTH/2);
            int drawY = (int) ((player.getY() - player.getLastY()) * interpolation + player.getLastY() - player.CHARHEIGHT/2);

            BufferedImageLoader loader = new BufferedImageLoader();
            BufferedImage spriteSheet = null;
            spriteSheet = ImageIO.read(ClassLoader.getSystemResource("\\Recources\\Character\\CharSheet.png") );
            SpriteSheet ss = new SpriteSheet(spriteSheet);

//            g.drawRect(drawX,drawY,10,10);
            BufferedImage sprite = ss.grabSprite(0,0,132,132);
            g.drawImage(sprite,drawX,drawY,null);





        } catch (Exception e){
            System.out.println("level loading failed");
//            e.printStackTrace();
        }




    }

    public void setInterpolation(float interp)
    {
        interpolation = interp;
    }

}
