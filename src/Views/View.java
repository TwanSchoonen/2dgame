package Views;

import Models.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by twan on 22-11-2016.
 */
public class View extends JPanel {

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

        //draw the player
        g.drawRect((int)player.getX(),(int) player.getY(), 10, 10);


    }
}
