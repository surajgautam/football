/*
 * DEVELOPER : SURAJ GAUTAM
 * CAMPUS: SHANKERDEV
 * FACULTY: BIM
 * COMPANY : UNKNOWN IT COMPANY
 */
package com.suraj.football;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Suraj Gautam
 */
public class GameOver extends JFrame implements ActionListener{
    
    
    ImageIcon gameover = new ImageIcon (getClass().getResource("/res/gameover.jpg"));
    JButton play;
    JButton quit;
    ImageIcon btnImage = new ImageIcon (getClass().getResource("/res/play.png"));
    GameOver(){
        initComponents();
        JLabel label= new JLabel(gameover);
        
        
        setSize(480,360);
        setContentPane(label);
        setTitle("GameOver");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        add(play);
        setVisible(true);
    }
     public void initComponents(){
         play = new JButton("Play");
         play.setBounds(230, 280, 80, 48);
         play.setBackground(Color.BLACK);
         play.setIcon(btnImage);
         play.addActionListener(this);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            this.dispose();
        }
    }
    
}
