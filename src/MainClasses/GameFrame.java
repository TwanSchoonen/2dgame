package MainClasses;

import Controllers.Controller;
import Models.Player;
import Views.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by twan on 22-11-2016.
 */
public class GameFrame extends JFrame{

    private View view;

    private Controller controller;

    private Player player;

    //width of the game Frame
    public static final int GAMEWIDTH = 700;
    //height of the game Frame
    public static final int GAMEHEIGHT = 500;

    public GameFrame() {
        super("Title test!!"); //set the title of the frame

        this.newGame();

        this.view = new View(); // init view
        this.add(view);

        view.linkPlayer(player);

        this.controller = new Controller(); //init controller
        this.addKeyListener(controller);
        controller.linkPlayer(player);

        new Thread(new GameThread(view, player)).start();

        setSize(GAMEWIDTH+6,GAMEHEIGHT+29); //Need to compensate for the border and title

        setLocationRelativeTo(null);

        setVisible(true); // makes the frame visible

        setResizable(false); //Makes it impossible to resize
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Able to close the frame
    }

    public void newGame(){
        this.player = new Player();
    }


}
