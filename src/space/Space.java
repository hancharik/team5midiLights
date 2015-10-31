/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Mark
 */




public class Space {
    

    
    
    public static Aframe screen;
    
    public static MidiFrame midiPlayer = new MidiFrame();
    
    
    
    
    
    
    
    //public static double universalGravitationalConstant = 6.67408;
    public static int universalGravitationalConstant = 6674;
    public static int ugcPowerOfTen = 1;  //this is an int value in powers of ten (-10 to 10 range?)
    
    
    public static double height = 1000;
    public static double width = 1880;
    public static int centerY = 500;//(int)(height/2);
    public static int centerX = 940;//(int)(width/2);
    
    
    public static int globalParticleSize = 16;
    public static double globalParticleMass = 10.0;
    public static double globalShipMass = 10.0;
   public static int globalAmountOfParticles = 1000;
   
   public static int gravityWellDistance = 200;
    public static double massOfCenter = 10.0;
   
    
    public static String globalSongName  = "Chicken";//= "TheMoneyWillRollRightIn";
    public static boolean playMidiMusic = true;
    public static int playMidiMusicNumber = 1;  // this gets set to zero on the apanel restart method
    
    
    
    
    
    public static boolean trigonometricMovement = false; // BY ALL THAT IS HOLY KEEP THIS OFF UNTIL WE FIND THE MATH ERROR!!!!!
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // the six variables for the throw box go here
    
    public static int boxX = 200;
    public static int boxY = 200;
    public static int boxWidth = 200;
    public static int boxHeight = 200;
    public static double boxXvel = 0.0;
    public static double boxYvel = 0.0;
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public static boolean globalSingularGravity = true; // when true, there is one point of gravity, when false, chained gravity
     public static boolean particles = false;  // when true, particles start everywhere
     public static boolean showStallman = false;
     public static boolean linearMovement = false;  // when true, this is our original movement 
     public static boolean gravityGetsStronger = true;
     public static boolean allParticlesHaveGravity = false; // leave this off until we get a fast processor!
     public static boolean thereIsAShip = false; // leave this off until we get a fast processor!
     public static boolean showCards = true; // leave this off until we get a fast processor!
     
     
     public static int currentSelectedElectronNumber = 1;
     public static String globalElementSymbol = "";
     public static String globalElementName = "";
     public static int globalElementNumber = 0;
     public static double globalAtomicMass  = 0.0;
     
     public static int globalStallmanSize = 1;// * globalParticleSizeMultiplier;
    public static int globalEnemySpeed = 1;
    
    public static int globalShipHeight = 20;
    public static int globalShipWidth = 20;
    public static int globalShipSpeedLimit = 23;
  
  public static int globalTimerSpeed = 42;
  public static  int globalSpeedlimit = 12;// + heroSize;// douglas adams is max
   public static int globalMinSpeed = 2;
    
   
   // these have yet to be added to the start panel
    public static int globalParticleSizeMultiplier = 3;
    public static int globalhelioSpeed = 10;
   public static int globalHelioSize = 40;// * globalParticleSizeMultiplier;
   
   
   
   
   
   
   
   public static JFrame f;
   
   
    public static void main(String[] args) {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      width = screenSize.getWidth();
      height = screenSize.getHeight();
        screen = new Aframe(); 
   
       
        
    }  // end main
    
    
    
    
    public static void fullAframe(){
        
         
        // @see http://stackoverflow.com/questions/7456227 
     EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                //screen.dispose();
                f = new JFrame("theProblem");
                new Apanel().display();
            }
        });
    
      
         
        
        
    }
    
    
    
    
    
    
    
}  // end
