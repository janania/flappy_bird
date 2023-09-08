package Flappy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * window class brings together the columns, bird, and gameEnd class to build
 * the game this window is added the FlappyBird jframe to complete the game
 * 
 * @author Janani Asokumar
 * @version 5/23/2021
 * @author Period 3
 */
public class window
    extends JPanel
    implements ActionListener
{

    private JFrame  frame; // declare frame
    private Image   img; // declare img
    private Bird    bird; // declare bird
    private Timer   time; // declare time
    private int     highScore; // declare highScore
    private int     score; // declare score
    private JLabel  scoreLabel; // declare scoreLabel

    private Columns col1; // declare col1
    private Columns col2; // declare col2
    private Columns col3; // declare col3

    
    /**
     * window class contructor
     * creates a new jFrame where all the other 
     * elements (columns, bird, gameEnd) are placed
     */
    public window()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        bird = new Bird();
        img = bird.getImage();

        setFocusable(true);
        addKeyListener(new AL());

        highScore = 0;
        score = 0;

        scoreLabel = new JLabel("" + score);
        this.add(scoreLabel);

        time = new Timer(5, this);
        time.start();

        col1 = new Columns(800);
        col2 = new Columns(1200);
        col3 = new Columns(1600);

    }


    /**
     *the method where the bird, base, columns are painted in jframe
     *the method id never called, it runs as soon as the window is created. 
     *@param g - the graphics
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);

        // column one
        g2d.fillRect(col1.getX(), 0, 100, col1.getLen());
        g2d.fillRect(col1.getX(), col1.getY2(), 100, 800);

        // column two
        g2d.fillRect(col2.getX(), 0, 100, col2.getLen());
        g2d.fillRect(col2.getX(), col2.getY2(), 100, 800);

        // column three
        g2d.fillRect(col3.getX(), 0, 100, col3.getLen());
        g2d.fillRect(col3.getX(), col3.getY2(), 100, 800);

        // bird
        g2d.drawImage(img, bird.getX(), bird.getY(), null);

        if (score % 33 == 0)
        {
            scoreLabel.setText("" + score / 33);
        }

        // base
        g2d.setColor(new Color(228, 213, 119));
        g2d.fillRect(0, 600, 1000, 400);
        g2d.setColor(new Color(144, 131, 50));
        g2d.fillRect(0, 600, 1000, 25);
    }


    /**
     * this method is called whenever an action is performed (any button clicked)
     * it makes the columns move, the bird jump, checks if the bird hit column, 
     * updates score, etc
     * @param e - the action performed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        col1.moveCol();
        col2.moveCol();
        col3.moveCol();

        bird.fall();

        Columns col = whichCol();

        if (col != null)
        {
            boolean passed = bird.passedColumn(col);
            if (passed && col.getX() < 200)
            {
                score += 1;
            }

        }
        if (bird.getEnded() == true)
        {
            time.stop();

            System.out.println(score);

            if (score > highScore)
            {
                System.out.println(score);
                System.out.println(highScore);
                highScore = score;
                System.out.println(highScore);
            }

            GameEnd end = new GameEnd(highScore / 33, this);
        }
        repaint();
    }


    /**
     * checks and returns which column the bird is about to pass next
     * it does this by comparing the location of the bird the columns. 
     * @return the column the bird is going to pass next
     */
    public Columns whichCol()
    {
        if (col1.getX() > 100 && col1.getX() < (bird.getX() + bird.getWidth()))
        {
            return col1;
        }
        else if (col2.getX() > 100 && col2.getX() < (bird.getX() + bird.getWidth()))
        {
            return col2;
        }
        else if (col3.getX() > 100 && col3.getX() < (bird.getX() + bird.getWidth()))
        {
            return col3;
        }

        return null;
    }

    /**
     * the class that implements the code for what happens when a specific key is pressed
     * when the space key is pressed the game is started, the bird moves up and down, etc
     * @author Janani Asokumar
     */
    private class AL
        extends KeyAdapter
    {
        /**
         * checks if the key pressed was a space bar
         * if so it calls the keyPressed methods of the bird and columns classes
         * @param e - the key pressed
         */
        public void keyPressed(KeyEvent e)
        {
            int k = e.getKeyCode();
            if (k == KeyEvent.VK_SPACE)
            {
                bird.setDY(1);

            }
            col1.keyPressed(e);
            col2.keyPressed(e);
            col3.keyPressed(e);
            bird.keyPressed(e);
        }


        /**
         * calls the birds key released method 
         * @param e - the key released
         */
        public void keyReleased(KeyEvent e)
        {
            bird.keyReleased(e);
        }
    }

    /**
     * restarts the game
     * by setting score to 0
     * creating new columns and bird objects and restarting the timer
     */
    public void restart()
    {
        score = 0;
        scoreLabel.setText("" + score);

        bird = new Bird();
        col1 = new Columns(800);
        col2 = new Columns(1200);
        col3 = new Columns(1600);

        repaint();

        time = new Timer(5, this);
        time.start();

    }
}
