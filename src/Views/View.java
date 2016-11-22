package Views;

import Models.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by twan on 22-11-2016.
 */
public class View extends JPanel {

    private float interpolation;
    private Player player;

    public View (int WIDTH, int HEIGHT){
        setSize(WIDTH,HEIGHT); //Set panel size
        setVisible(true);
        setBackground(new Color(9, 96, 18));
    }

    public void linkPlayer(Player player) {
        this.player = player;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int drawX = (int) ((player.getX() - player.getLastX()) * interpolation + player.getLastX() - player.CHARWIDTH/2);
        int drawY = (int) ((player.getY() - player.getLastY()) * interpolation + player.getLastY() - player.CHARHEIGHT/2);

        //draw the player
        g.drawRect(drawX,drawY, 10, 10);
    }

    public void setInterpolation(float interp)
    {
        interpolation = interp;
    }
}
