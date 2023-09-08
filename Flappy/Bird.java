package Flappy;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Bird class that makes an image for the bird manipulates the x and y values of
 * the bird checks if the bird hits the col codes what to do when a space bar is
 * pressed
 *
 * @author TODO Janani Asokumar
 * @version TODO 5/22/2021
 * @author Period 3
 */
public class Bird
    extends Component
{
    int               x, y, dy; // declares x, y, dy
    private Image     bird;// declares bird
    private ImageIcon b; // declares b
    private boolean   ended; // declares ended

    /**
     * constructor of the bird class initializes all the private field variables
     */
    public Bird()
    {
        x = 200;
        y = 250;
        dy = 0;
        b = new ImageIcon("bird_1_35.png");
        ended = false;
        bird = b.getImage();
    }


    /**
     * returns the bird image
     * 
     * @return the bird image
     */
    public Image getImage()
    {
        return bird;
    }


    /**
     * returns y pos of the bird
     * 
     * @return y pos of bird
     */
    public int getY()
    {
        return y;
    }


    /**
     * returns x pos of the bird
     * 
     * @return x pos of the bird
     */
    public int getX()
    {
        return x;
    }


    /**
     * sets the y values to the param
     * 
     * @param changeTo
     *            - values to change y pos to
     */
    public void setY(int changeTo)
    {
        y = changeTo;
    }


    /**
     * makes the bird go up by subtracting 100 from y pos ends the game if the
     * bird hits the top
     */
    public void fly()
    {
        y -= 100;

        if (y < 0)
        {
            ended = true;
        }
    }


    /**
     * sets dy to param
     * 
     * @param d
     *            - values to set dy to
     */
    public void setDY(int d)
    {
        dy = d;
    }


    /**
     * returns boolean of ended
     * 
     * @return boolean of ended
     */
    public boolean getEnded()
    {

        return ended;
    }


    /**
     * makes the bird go down by adding value to y if the bird hits the bottom,
     * sets game ended to true
     */
    public void fall()
    {
        y += dy * 5.5;

        if (y >= 580)
        {
            ended = true;
        }
    }


    /**
     * makes the bird fly when the space bar is pressed
     * 
     * @param e
     *            - the key pressed
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE)
        {
            fly();
        }
    }


    /**
     * makes the bird fall when the key is released
     * 
     * @param e
     *            - key released
     */
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE)
        {
            fall();
        }
    }


    /**
     * checks if the bird successfully went through the col (param) without
     * hitting it
     * 
     * @param col
     *            - column to check passing
     * @return if the bird passed the col successfully
     */
    public boolean passedColumn(Columns col)
    {

        if (y >= col.getLen() && (y + getHeight()) <= col.getY2())
        {
            return true;
        }

        ended = true;
        return false;
    }


    /**
     * returns width of the bird image
     * 
     * @return width of the bird image
     */
    public int getWidth()
    {
        return b.getIconWidth();
    }


    /**
     * returns the height of the bird image
     * 
     * @return height of the bird image
     */
    public int getHeight()
    {
        return b.getIconHeight();
    }
}
