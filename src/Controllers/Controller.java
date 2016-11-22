package Controllers;

import Models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by twan on 22-11-2016.
 */
public class Controller implements KeyListener {

    private Player player;

    public void linkPlayer(Player player){
        this.player = player;
    }

    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if (x == KeyEvent.VK_UP){
           player.updateY(-1);
        }
        if (x == KeyEvent.VK_LEFT){
            player.setX(player.getX()-1);
        }
        if (x == KeyEvent.VK_RIGHT){
            player.setX(player.getX()+1);
        }
        if (x == KeyEvent.VK_DOWN){
            player.updateY(+1);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
