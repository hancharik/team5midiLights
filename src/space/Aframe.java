/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

/**
 *
 * @author Mark
 */
public class Aframe extends JFrame{
    
    
    //int height;// = space.Space.height;
    //int width;// = space.Space.width;
     int height = (int)space.Space.height;
    int width = (int)space.Space.width;   
    
   
    Apanel gamePanel;// = new Apanel();
    
     
   
    StartPanel startPanel;// = new StartPanel();
    
   
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    TeamPanel1 teamPanel1;
    TeamPanel2 teamPanel2;
    TeamPanel3 teamPanel3;
    TeamPanel4 teamPanel4;
    TeamPanel5 teamPanel5;
    TeamPanel6 teamPanel6;
    TeamPanel7 teamPanel7;
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    public Aframe(){
        
		super ("BES Particle Simulator");
                getContentPane().setLayout(new BorderLayout());
                getRootPane().setDoubleBuffered(true);  // omg please work
                setExtendedState(JFrame.MAXIMIZED_BOTH);//setSize (width, height);
                width = this.getWidth();
                height = this.getHeight();
                startPanel = new StartPanel();
		getContentPane().add(startPanel,"Center");//getContentPane().add(startPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
                
        }
    
    
    public void startPanel(){
        
        getContentPane().removeAll();
        
                startPanel = new StartPanel();
                
		getContentPane().add(startPanel,"Center");
                
		setVisible(true);
     
        
    }
    

    
    
    
     public void start(){
         
                getContentPane().removeAll();
                gamePanel = new Apanel();
                getContentPane().add(gamePanel,"Center");
                setVisible(true);
                gamePanel.helio.requestFocus();
        
    }   
     


     
     public void restart(){
         
                getContentPane().removeAll();
                space.Space.playMidiMusicNumber = 0;
                gamePanel = new Apanel();
                getContentPane().add(gamePanel, "Center");
                setVisible(true);
                gamePanel.helio.requestFocus();
        
    }
 
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////    
  // team methods   
       
     public void start1(){
         
                getContentPane().remove(startPanel);
                teamPanel1 = new TeamPanel1();
                getContentPane().add(teamPanel1,"Center");
                setVisible(true);
                teamPanel1.helio.requestFocus();
        
    }     
    public void start2(){
         
                getContentPane().remove(startPanel);
                teamPanel2 = new TeamPanel2();
                getContentPane().add(teamPanel2,"Center");
                setVisible(true);
               teamPanel2.helio.requestFocus();
        
    }     
    public void start3(){
         
                getContentPane().remove(startPanel);
                teamPanel3 = new TeamPanel3();
                getContentPane().add(teamPanel3,"Center");
                setVisible(true);
               teamPanel3.helio.requestFocus();
        
    }     
    public void start4(){
         
                getContentPane().remove(startPanel);
                teamPanel4 = new TeamPanel4();
                getContentPane().add(teamPanel4,"Center");
                setVisible(true);
               teamPanel4.helio.requestFocus();
        
    }     
    public void start5(){
         
                getContentPane().remove(startPanel);
                teamPanel5 = new TeamPanel5();
                getContentPane().add(teamPanel5,"Center");
                setVisible(true);
                teamPanel5.helio.requestFocus();
        
    }     
    public void start6(){
         
                getContentPane().remove(startPanel);
                teamPanel6 = new TeamPanel6();
                getContentPane().add(teamPanel6,"Center");
                setVisible(true);
                teamPanel6.helio.requestFocus();
        
    }     
    public void start7(){
         
                getContentPane().remove(startPanel);
                teamPanel7 = new TeamPanel7();
                getContentPane().add(teamPanel7,"Center");
                setVisible(true);
                teamPanel7.helio.requestFocus();
        
    }     
     
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    
    
    
    
    
    
    public void display() {
        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice dev = env.getDefaultScreenDevice();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.darkGray);
        setResizable(false);
        setUndecorated(true);
        add(this);
        pack();
        dev.setFullScreenWindow(this);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  // end
