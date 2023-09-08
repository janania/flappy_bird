package Flappy;
import java.awt.event.*;

//import javax.swing.*;//import java.awt.*;

//import java.awt.geom.Ellipse2D;
//import java.lang.reflect.Array;

/**
 * Columns class represents a single column it has methods that manipulate the x
 * and y coordinates of the columns gives it the illusion that the column moves
 * and reappears.
 *
 * @author TODO Janani Asokumar
 * @version TODO 5/22/2021
 * @author Period 3
 */
public class Columns
{
    private int     x; // declare x
    private int     y; // declare y
    private int     y2; // declare y2
    private int     len; // declare len
    private int     dx;; // declare dx
    private int[][] heights; // declare heights

    /**
     * constructor of the columns class intializes all the private field
     * variables
     * 
     * @param xpos
     *            - the position to place the column
     */
    public Columns(int xpos)
    {

        x = xpos;
        y = 0;
        y2 = 0;
        len = 0;
        heights = new int[6][6];

        addHeights();
        changeHeight();
    }


    /**
     * sets the dx (distance to move the column) to -3 (moves left)
     * 
     * @param e
     *            - the key pressed
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE)
        {
            dx = -3;
        }
    }


    /**
     * adds varies heights to the heights array
     */
    public void addHeights()
    {
        heights[0][0] = 300;
        heights[0][1] = 500;

        heights[1][0] = 180;
        heights[1][1] = 380;

        heights[2][0] = 350;
        heights[2][1] = 550;

        heights[3][0] = 220;
        heights[3][1] = 420;

        heights[4][0] = 325;
        heights[4][1] = 525;

        heights[5][0] = 150;
        heights[5][1] = 350;
    }


    /**
     * moves the col by adding dx to the x calls the reappear column method
     */
    public void moveCol()
    {
        x = x + dx;
        reappearColumn();
    }


    /**
     * makes the column reappear if its off screen of the left changes the
     * height only if the column should reappear
     */
    public void reappearColumn()
    {
        if (x <= -100)
        {
            x = 1100;
            changeHeight();
        }
    }


    /**
     * changes the height (opening) by choosing at random values from the
     * heights array
     */
    public void changeHeight()
    {
        int randInt = (int)((Math.random() * (6)));
        len = heights[randInt][0];
        y2 = heights[randInt][1];

    }


    /**
     * return x position
     * 
     * @return x position
     */
    public int getX()
    {
        return x;
    }


    /**
     * return len of the col
     * 
     * @return len of col
     */
    public int getLen()
    {
        return len;
    }


    /**
     * return y2 of the col
     * 
     * @return y2 of th col
     */
    public int getY2()
    {
        return y2;
    }
}
