package Flappy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;

/**
 * FlappyBird Constructor: adds the window Jframe to this Jframe
 * Calls the flappyBird class to intiate the game. 
 * @author Janani Asokumar
 * @version  1/22/2021
 * @author Period 3
 */
public class FlappyBird 
{
   
    private window w; //declare window
    
    /**
     * constructor of the flappyBird class
     * creates the jframe of the entire games
     * creates a adds a window object to the jframe
     * Initializes all the private field variables
     */
    public FlappyBird() {
        JFrame frame = new JFrame();
        window w = new window();
        frame.add(w);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
    
    /**
     * driver/main method of the flappyBird class 
     * calls the flappyBird class to intiate the game 
     * @param args - what does it do :((
     */
    public static void main(String []args)
    {
        FlappyBird Flappy = new FlappyBird();
    }

}
