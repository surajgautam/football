/*
 * DEVELOPER : SURAJ GAUTAM
 * CAMPUS: SHANKERDEV
 * FACULTY: BIM
 * COMPANY : UNKNOWN IT COMPANY
 */
package com.suraj.football;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Suraj Gautam
 */
class PlayGround extends JPanel implements ActionListener, KeyListener {

    private Random random = new Random();
    private ImageIcon background = new ImageIcon(getClass().getResource("/res/background.png"));
    private  ImageIcon ball = new ImageIcon(getClass().getResource("/res/ball.png"));
    int count;
    int scoreFor2;
    int score = 0;
    int best = 0;
    int x = 100;
    int y = 335;
    int velX = 6;
    int velY = -6;
    int delay = 35;
    int tm = 40;
    Timer timer = new Timer(delay, this);

    PlayGround() {
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        background.paintIcon(this, g, 0, 0);
        ball.paintIcon(this, g, x, y);

        g.setColor(new Color(255, 204, 0));
        g.setFont(new Font("Arial", Font.ITALIC, 25));
        g.drawString("SCORE: " + String.valueOf(score), 100, 35);
        g.drawString("BEST:" + String.valueOf(best), 100, 70);

    }
// since the implementation of a KeyLisener, which would require the panel to be in a focused 
    //state. With the addNotify(), it just adds the listeners

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Defender");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(266, 425); //width and height same as background image
        f.add(new PlayGround());
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (y < 0) {
            velY = -velY;

        }
        if (y > 335) {
            velY = -velY;

        }
        if (x < 0) {
            velX = -velX;
        }
        if (x > 200) {
            velX = -velX;
        }

        x += velX;
        y += velY;
        if (y > 335) {

            if (score > best) {
                scoreFor2 = score;
                best = score;
            }
            score = 0;
            if(score == 0){
                count = 1;
                if(count == 1){
                    count++;
                new GameOver();
                tm = 40;
                }
            }
            timer.stop();

        }
        updateY(y);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        timer.start();
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            if (y > 250) {
                score++;
                timer.stop();
                timer.setDelay(tm);
                timer.start();
                if (tm == 0) {
                    tm = tm;
                } else {
                    tm--;
                }

                y = random.nextInt(100);
                x = random.nextInt(150);

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void updateY(int y) {
        this.y = y;
    }

}
