package MainClasses;

import Views.View;

/**
 * Created by twan on 22-11-2016.
 */
public class GameThread implements Runnable{

    private View view;

    private boolean running = true;

    public GameThread(View view){
        this.view=view;
    }

    public void run() {
        while (running) {
            view.repaint();
        }
        System.out.println("savely ended thread");
    }

}
