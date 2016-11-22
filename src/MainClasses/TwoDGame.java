package MainClasses;

import javax.swing.*;

/**
 * Created by twan on 22-11-2016.
 */
public class TwoDGame extends JFrame{

    //width of the game Frame
    private static final int WIDTH = 300;
    //height of the game Frame
    private  static final int HEIGHT = 300;

    public TwoDGame() {
        super("Title test!!"); //set the title of the frame

        setSize(WIDTH+32,HEIGHT+32);
        setVisible(true); // makes the frame visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Able to close the frame
    }



}
