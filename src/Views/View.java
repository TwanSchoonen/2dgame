package Views;

import Models.Objects.MapObject;
import Models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by twan on 22-11-2016.
 */
public class View extends JPanel {

    private float interpolation;
    private Player player;
    private int WIDTH;
    private int HEIGHT;

    public View (int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        setSize(WIDTH,HEIGHT); //Set panel size
        setVisible(true);
        setBackground(new Color(96, 3, 69));
    }

    public void linkPlayer(Player player) {
        this.player = player;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw current level
        try {
            //draw background
            Image background = ImageIO.read( ClassLoader.getSystemResource(player.getCurrentLevel().getBackgroundPath()) );
            g.drawImage(background,0,0,null);

            //draw level objects
            for(MapObject o : player.getCurrentLevel().getMapObjects()){
                Image mapObject = ImageIO.read( ClassLoader.getSystemResource(o.getGraphicPath()) );
                g.drawImage(mapObject, o.getX(), o.getY(), null);
            }

            //draw player
            int drawX = (int) ((player.getX() - player.getLastX()) * interpolation + player.getLastX() - player.CHARWIDTH/2);
            int drawY = (int) ((player.getY() - player.getLastY()) * interpolation + player.getLastY() - player.CHARHEIGHT/2);

            BufferedImageLoader loader = new BufferedImageLoader();
            BufferedImage spriteSheet = null;
            spriteSheet = ImageIO.read(ClassLoader.getSystemResource("\\Recources\\Character\\CharSheet.png") );
            SpriteSheet ss = new SpriteSheet(spriteSheet);

            
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
