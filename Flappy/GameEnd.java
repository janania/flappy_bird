package Flappy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

/**
 * the gameEnd jframe that appears when the bird hits a column, top or bottom of
 * frame a frame pops up stating high score and if the player wants to quit the
 * game or continue playing
 *
 * @author Janani Asokumar
 * @version 5/23/2021
 * @author Period: 3
 */
public class GameEnd
    extends JFrame
{
    private JFrame     gameEnd; // declare gameEnd
    private FlappyBird main; // declare main
    private window     window; // declare window

    /**
     * constructor of the gameEnd Initializes the field variables using given
     * params
     * 
     * @param highScore
     *            - the highscore to display
     * @param window
     *            - the window to display the game end jFrame on
     */
    public GameEnd(int highScore, window window)
    { /* int highScr, HighScore highScore, FlappyBird main */

        // int highScore, Window window

        gameEnd = this;
        gameEnd.setSize(300, 300);
        gameEnd.setDefaultCloseOperation(3);//// I ADDED THIS
        gameEnd.setLocationRelativeTo(null);//// I ADDED THIS

        this.window = window;

        JLabel ended = new JLabel("Game End");
        ended.setFont(new Font(ended.getFont().getName(), Font.PLAIN, 40));

        JLabel highScoreLabel = new JLabel("High Score: " + highScore);
        highScoreLabel.setFont(new Font(highScoreLabel.getFont().getName(), Font.PLAIN, 30));

        JButton restart = new JButton("Play Again");
        restart.setPreferredSize(new Dimension(120, 30));

        JButton quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(120, 30));

        RestartListener restartListener = new RestartListener();
        restart.addActionListener(restartListener);

        QuitListener quitListener = new QuitListener();
        quit.addActionListener(quitListener);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(177, 222, 220));

        panel.add(new JLabel("                                  "));  // filler
        panel.add(new JLabel("                                  "));  // filler
        panel.add(new JLabel("                                                  "));  // filler

        panel.add(ended);
        panel.add(new JLabel("                                  "));  // filler

        panel.add(highScoreLabel);
        panel.add(new JLabel("                                                  "));  // filler
        panel.add(new JLabel("                                                  "));  // filler

        panel.add(restart);
        panel.add(quit);

        gameEnd.add(panel);

        gameEnd.setVisible(true);
    }

    private class RestartListener
        implements ActionListener
    {
        /**
         * when play again was clicked removes gameEnd frame restarts the game
         * 
         * @param e
         *            - the event that happened (button clicked)
         */
        public void actionPerformed(ActionEvent e)
        {
            gameEnd.dispose();
            window.restart();
        }
    }


    private class QuitListener
        implements ActionListener
    {
        /**
         * when the quit button is clicked, it ends the game
         * 
         * @param 2
         *            - the even that happened (button clicked)
         */
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
