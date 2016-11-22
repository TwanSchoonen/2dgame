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
           player.setMoveUp(true);
           player.setMoveDown(false);
        }
        if (x == KeyEvent.VK_LEFT){
            player.setMoveLeft(true);
            player.setMoveRight(false);
        }
        if (x == KeyEvent.VK_RIGHT){
            player.setMoveRight(true);
            player.setMoveLeft(false);
        }
        if (x == KeyEvent.VK_DOWN){
            player.setMoveDown(true);
            player.setMoveUp(false);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
        int x = e.getKeyCode();
        if (x == KeyEvent.VK_UP){
            player.setMoveUp(false);
        }
        if (x == KeyEvent.VK_LEFT){
            player.setMoveLeft(false);
        }
        if (x == KeyEvent.VK_RIGHT){
            player.setMoveRight(false);
        }
        if (x == KeyEvent.VK_DOWN){
            player.setMoveDown(false);
        }
    }
}
