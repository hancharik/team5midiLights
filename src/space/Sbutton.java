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
    int speedLimit;// 
    double mass = 1.0;// = space.Space.globalParticleMass;
    
    
    public Sbutton(){
        
        super();
        mass = space.Space.globalParticleMass;
        this.setBorderPainted(false);
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
     //speedLimit = arena.Arena.screen.gamePanel.speedspeedit;
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

    
        public void setColor(){
         
         Color whatsMyColor = Color.red;
         int sl = space.Space.globalSpeedlimit;
         
         if(speedLimit * 100 > sl * 80){
            whatsMyColor = Color.RED; 
         }else if(speedLimit * 100 > sl * 70){
           whatsMyColor = Color.ORANGE;  
         }else if(speedLimit * 100 > sl * 50){
           whatsMyColor = Color.YELLOW;  
         }else if(speedLimit * 100 > sl * 40){
            whatsMyColor = Color.GREEN; 
         }else if(speedLimit * 100 > sl * 30){
            whatsMyColor = Color.BLUE; 
         }else if(speedLimit * 100 > sl * 20){
           whatsMyColor = Color.MAGENTA;  
         }else{
           whatsMyColor = Color.WHITE;   
         }
             
     
      this.setBackground(whatsMyColor);
         
     }
       
    
     
     //////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
   public void applyForceOfGravity(Sbutton b){
       
       
       double distance = Math.sqrt((b.getX()-this.getX())*(b.getX()-this.getX())+(b.getY()-this.getY())*(b.getY()-this.getY()));
       double powerOfTen = 1.0;
            for(int i = 0; i < Math.abs(space.Space.ugcPowerOfTen); i++){
            powerOfTen = powerOfTen * 10; 
         }
         
       if(space.Space.ugcPowerOfTen < 0){
           powerOfTen = (1/powerOfTen);
       }  
       double uniGravConst = space.Space.universalGravitationalConstant * powerOfTen;
       double gravitationalAttraction = (uniGravConst * this.mass * b.mass) / (distance * distance);
     
     
     double angle = (double) Math.toDegrees(Math.atan2((b.getY()-this.getY()), (b.getX()-this.getX())));

    if(angle < 0.0){
        angle += 360.0;
    }
     
     
     xVel = xVel +  ((double)(Math.cos(angle*Math.PI/180)) * gravitationalAttraction);
     
    yVel = yVel +  (double)(Math.sin(angle*Math.PI/180)) * gravitationalAttraction;
       
   
    // this.setLocation(this.getX() - (int)xVel, this.getY() - (int)yVel);   
       
   } // end applyForceOfGravity 
     
     
     
     
 
     
     
     
     
         public void checkCollision(){
       
      // for(int i = 0; i < something.size(); i++){
        
                    // if (this.getBounds().intersects(something.get(i).getBounds())){

                     // }     
       
       
       //}
             
             
             
         }  // end check collision
  
       
}  // end
