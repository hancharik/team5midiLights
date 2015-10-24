/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Mark
 */
public class Sbutton extends JButton{
    
   
    
    double xVel = 0.0;
    double yVel = 0.0;
    int speedLimit;// = arena.Arena.screen.gamePanel.speedlimit;
    double mass;// = space.Space.globalParticleMass;
    
    
    public Sbutton(){
        
        super();
        mass = space.Space.globalParticleMass;
        //randomizeIcons();
        
    }
    
    public void makeShip(int type, int idNumber){
    // there is a way to have preset sizes based on type here, the ufo in the 'images/ufo1.png' can be a variable
       
        // if you leave these here as defaults, then you can overwrite
        space.Space.globalShipHeight = 20; 
        space.Space.globalShipWidth = 20;
        
        String typeOfCraft = "camel";
        
        switch(type){
            case 1 : typeOfCraft = "ufo"; space.Space.globalShipHeight = 40; space.Space.globalShipWidth = 76; break;
        }
        
        this.setIcon(new ImageIcon("images/"+typeOfCraft+idNumber+".png"));
        
       
        
    }
    

   
       
  
       
     public void makeHero(){
       
   
       this.setIcon(new ImageIcon("images/rms.png"));
       
  }  
   
   
     
     
    //////////////////////////////////////////////////////////////////// 
     
     
     
     
     
     
     public void move(){
     //speedLimit = arena.Arena.screen.gamePanel.speedlimit;
         int negativeSpeedLimit = speedLimit - (speedLimit*2);
         
         if(xVel > speedLimit){
             xVel = speedLimit;
         }else  if(xVel < negativeSpeedLimit){
             xVel = negativeSpeedLimit;
         }
         
         if(yVel > speedLimit){
             yVel = speedLimit;
         }else if(yVel < negativeSpeedLimit){
             yVel = negativeSpeedLimit;
         }
         
     this.setLocation(this.getX() + (int)xVel, this.getY() + (int)yVel); 
     
     
     
     
     
  }  
    
   
     
     
     
     
     ////////////////////////////////////////////////////////////////////////////////
     
     public void setColor(int lim){
         
         Color whatsMyColor = Color.red;
         
         if(speedLimit * 100 > lim * 80){
            whatsMyColor = Color.RED; 
         }else if(speedLimit * 100 > lim * 70){
           whatsMyColor = Color.ORANGE;  
         }else if(speedLimit * 100 > lim * 50){
           whatsMyColor = Color.YELLOW;  
         }else if(speedLimit * 100 > lim * 40){
            whatsMyColor = Color.GREEN; 
         }else if(speedLimit * 100 > lim * 30){
            whatsMyColor = Color.BLUE; 
         }else if(speedLimit * 100 > lim * 20){
           whatsMyColor = Color.MAGENTA;  
         }else{
           whatsMyColor = Color.BLACK;   
         }
             
         
         
         
         
         
         
         
      this.setBackground(whatsMyColor);
         
     }
     
     
     
     
     
     //////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
         public void checkCollision(){
       
      // for(int i = 0; i < arena.Arena.screen.gamePanel.stuffBucketSize; i++){
          // for(int j = 0; j < arena.Arena.level; j++){
      // if (this.getBounds().intersects(arena.Arena.screen.gamePanel.stuffBucket.get(i).getBounds())){
          // zombiebutton.Arena.screen.stuffBucket[i]  
                 //   arena.Arena.screen.gamePanel.stuffBucket.get(i).setVisible(false);
                  //  arena.Arena.screen.bucket.treasures[i].setVisible(true);
                    //.remove(zombiebutton.Arena.screen.gamePanel.stuffBucket[i]); 
       // }     
       
       
       //}
             
             
             
         }  // end check collision
  
       
}
