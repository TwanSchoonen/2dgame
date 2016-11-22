package MainClasses;

import Models.Player;
import Views.View;

/**
 * Created by twan on 22-11-2016.
 */
public class GameThread implements Runnable{

    private View view;

    private Player player;

    private boolean running = true;

    public GameThread(View view, Player player){
        this.view=view;
        this.player = player;
    }

    public void run() {
        while (running) {

            player.updateMovement();

            view.repaint();

//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

        }
        System.out.println("savely ended thread");
    }

}
