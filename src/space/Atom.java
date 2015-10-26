/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class Atom extends JPanel implements ActionListener, KeyListener, MouseListener {
    
    
    
    
    int particleSize = space.Space.globalParticleSize;
    int numberOfElectrons;
    int sizeOfNucleus; 
    int protonSize = 4;
    int electronSize = 2;
    
    int enemySpeed = space.Space.globalEnemySpeed;
    int nucleusSpeedLimit;
    int nucleusSpeedLimitModifier = 18;
    
    int centerPointSpeed = 10;
    int timerSpeed = space.Space.globalTimerSpeed;
    int speedlimit = space.Space.globalSpeedlimit;// + sizeOfNucleus;// douglas adams is max1
    int minSpeed = space.Space.globalMinSpeed;
    Sbutton centerPoint;
    Sbutton ship;
    ArrayList<Sbutton> electrons;// = new ArrayList();
    ArrayList<Sbutton> nucleus;

    
    
    
    
    int screenWidth;
    int screenHeight;
  
    
    Timer timer;
    boolean singularGravity = true;
    
    
    int Xcord = 320;// = (int) (Math.random() * 400) + 1;
    int Ycord = 220;/// = (int) (Math.random() * 340) + 1;
    
    
    
    
    
    
    
    
    public Atom(){
       
       super();
       
       setLayout(null);
       setBackground(Color.black);
       addMouseListener(this);
       addKeyListener(this);
       setVariables();
       
       electrons = new ArrayList();
       nucleus = new ArrayList();
        addNucleus();
        addProtonsAndNeutrons();
        //electrons.add(centerPoint);
        addElectrons();
      
        
        //electrons.add(centerPoint);
      
  /////////////////////////////////////////////
        //////////////////////////////////////
        //////////////////////////////////////////
        
        
        
        
        
      
        
        
        
        
        
        
        
        ////////////////////////////////////////
        ////////////////////////////////////////
        //////////////////////////////////
      
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
      // if we have this, do we need the stuff at the bottom?
      addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
                                    if(space.Space.thereIsAShip){
                                        ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);   
                                        ship.xVel = 0.0;
                                        ship.yVel = 0.0;
                                           }else{
                                        centerPoint.setBounds(e.getX(), e.getY(), sizeOfNucleus, sizeOfNucleus);
                                            }
                                    }
                                });
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
      
 
       timer = new Timer( timerSpeed, this);
       timer.start();
       centerPoint.requestFocus();
       //requestFocus();
    }  // end constructor
 
    
    
    
    
    
    
    
    
    
    
    public void setVariables(){
        
        singularGravity = space.Space.globalSingularGravity;
          particleSize = space.Space.globalParticleSize;
   numberOfElectrons = space.Space.currentSelectedElectronNumber;
     nucleusSpeedLimit = (numberOfElectrons/nucleusSpeedLimitModifier)+1;
     
     sizeOfNucleus = 1;//numberOfElectrons;
     //int sizeOfNucleus = numberOfElectrons;
    
     enemySpeed = space.Space.globalEnemySpeed;
    
    centerPointSpeed = 10;
    timerSpeed = space.Space.globalTimerSpeed;
     speedlimit = 60;//space.Space.globalSpeedlimit;// + sizeOfNucleus;// douglas adams is max
     minSpeed = space.Space.globalMinSpeed;
     
     screenWidth = (int)space.Space.width;
    screenHeight = (int)space.Space.height;
   
     
     
    }  // end set variables 
    
    
    
    public void addNucleus(){
        
        if(space.Space.thereIsAShip){
            ship = new Sbutton();
            ship.setBounds(20, 20, space.Space.globalShipWidth, space.Space.globalShipHeight);
            ship.setBackground(Color.GRAY);
            ship.addActionListener(this);
            ship.addKeyListener(this);
            ship.speedLimit = space.Space.globalShipSpeedLimit;
            ship.xVel = 5.0;
            ship.yVel = 5.0;
            electrons.add(ship);  // this is how we add movement, we just add the ship to the particle array and it gets moved when all of the other electrons get moved
            ship.makeShip(1, 1);// first 1 is type (1=="ufo"), second 1 is id number
            ship.setBorderPainted(false);
            add(ship);
      }
        
        //Xcord = 100;//(screenWidth/2);
       // Ycord = 100;//(screenHeight/2);
         //sizeOfNucleus = space.Space.globalHelioSize;
         
        centerPoint = new Sbutton();
        centerPoint.setBounds(Xcord, Ycord, 0, 0);
        centerPoint.setBackground(Color.YELLOW);
        centerPoint.addActionListener(this);
        centerPoint.addKeyListener(this);
        centerPoint.setBorderPainted(false);
       // centerPoint.setVisible(false);
        if(space.Space.showStallman){
            sizeOfNucleus = space.Space.globalStallmanSize;
        centerPoint.makeHero();
        
        }
        //centerPoint.setBounds(Xcord, Ycord, sizeOfNucleus, sizeOfNucleus);
        centerPoint.mass = space.Space.massOfCenter;
        add(centerPoint);  
        
        
    }  // end add nucleus
  
    
    
    
    
    
    
    
         public void addElectrons(){
          
          numberOfElectrons = space.Space.currentSelectedElectronNumber;
         
         for(int i = 0; i < numberOfElectrons; i++){
             Xcord = centerPoint.getX() - ((int)(Math.random() * 400) - 200);//(int) (Math.random() * (space.Space.screen.width-300)) + 200;
         Ycord = centerPoint.getY() - ((int)(Math.random() * 400)  - 200);//(int) (Math.random() * (space.Space.screen.height-300)) + 200;
         //int xsp = 30;
         //int ysp = -10;
         // this is our cast, we "throw" them to try to get an orbit
         int xsp = 0;
         int ysp = 0;
         
         
       
         
          Sbutton a = new Sbutton();
         
        //electrons.get(i) = new Sbutton();
        a.setBounds(Xcord, Ycord, electronSize, electronSize);
        a.setBackground(Color.red);
        a.xVel = xsp;
        a.yVel = ysp;
        a.mass = space.Space.globalParticleMass;
        a.addActionListener(this);
        a.setBorderPainted(false);
       // a.speedLimit = speedlimit;//(int)(Math.random() * speedlimit) + minSpeed;
       // a.setColor(speedlimit);
         electrons.add(a);
        add(a);   
        
         }
         
         setElectronShells();
         
    }  // end add electrons
    
    
         
         
    
      public void addProtonsAndNeutrons(){
          
          numberOfElectrons = space.Space.currentSelectedElectronNumber;
         
         for(int i = 0; i < numberOfElectrons; i++){
             
             
         Xcord = centerPoint.getX() - ((int)(Math.random() * 20) - 10);//(int) (Math.random() * (space.Space.screen.width-300)) + 200;
         Ycord = centerPoint.getY() - ((int)(Math.random() * 20) - 10);//(int) (Math.random() * (space.Space.screen.height-300)) + 200;
         //int xsp = 30;
         //int ysp = -10;
         // this is our cast, we "throw" them to try to get an orbit
         int xsp = 0;
         int ysp = 0;
        
         // you have to randomize the placement, or the protons seem to cover up the neutrons
        int offsetX = (int)(Math.random() * 4) - 2;
        int offsetY = (int)(Math.random() * 4) - 2; 
        Sbutton proton = new Sbutton();
        proton.setBounds(Xcord + offsetX, Ycord + offsetY, protonSize, protonSize);
        proton.setBackground(Color.BLUE);
        proton.xVel = xsp;
        proton.yVel = ysp;
        proton.mass = space.Space.globalParticleMass;
        proton.addActionListener(this);
        proton.speedLimit = nucleusSpeedLimit;
        proton.setBorderPainted(false);
        nucleus.add(proton);
        add(proton);   
        offsetX = (int)(Math.random() * 4) - 2;
        offsetY = (int)(Math.random() * 4) - 2; 
        Sbutton neutron = new Sbutton();
        neutron.setBounds(Xcord + offsetX, Ycord + offsetY, protonSize, protonSize);
        neutron.setBackground(Color.WHITE);
        neutron.xVel = xsp;
        neutron.yVel = ysp;
        neutron.mass = space.Space.globalParticleMass;
        neutron.addActionListener(this);
        neutron.speedLimit = nucleusSpeedLimit;
        neutron.setBorderPainted(false);
        nucleus.add(neutron);
        add(neutron); 
        
        
        
        
         }
         
         //setElectronShells();
         
    }  // end add protons and neutrons
 
      
     public  void setElectronShells(){
       
   
          String shell = "X";
          
          numberOfElectrons = 9;
          
          double speedLimitAsDouble = (double) speedlimit;
          double shellSpeed = 0.0;
          
          
          
            for(int j = 0; j <  electrons.size(); j++){
                
                
                
                 // THIS IS WHERE IS GETS FUNKY, we need to implement subshells at some point  https://en.wikipedia.org/wiki/Electron_shell 
                int i = j;
                
                
                
                // this is a bad suborbital quick fix
                    if(i>58){
                    i = (int)(Math.random() * 38) + 19; 
                    }
                
                    
                    
        
                    
                    
                    
            if(i<2){
              shell = "K"; shellSpeed = speedLimitAsDouble * .18;
            }        
                    
            else if(i<10){
              shell = "L";shellSpeed = speedLimitAsDouble * .26;
            }  else if(i<18){
              shell = "M"; shellSpeed = speedLimitAsDouble * .36; 
            }  else if(i<26){
               shell = "N"; shellSpeed = speedLimitAsDouble * .46; 
            }  else if(i<34){
               shell = "O"; shellSpeed = speedLimitAsDouble * .65;
           } else if(i<42){
                shell = "P"; shellSpeed = speedLimitAsDouble * .77;
            }  else {
               shell = "Q"; shellSpeed = speedLimitAsDouble * .91;
            }
          
   
           
            electrons.get(j).speedLimit = (int)shellSpeed;
            electrons.get(j).setColor();
        }   
        
   } // end set electron shells
      
      
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == timer){


                    moveParticle(electrons);
                    moveParticle(nucleus);


                }
        
        
       
   

		if (obj == centerPoint){
                    
                    timer.stop();
                  
                    space.Space.screen.startPanel();
                  
                }
    
    } // end action performed
         
         
         
         
         
         

    @Override
    public void keyTyped(KeyEvent e) {
        int k = e.getKeyCode();
		if(k == e.VK_UP){
                    if(space.Space.thereIsAShip){
                        ship.yVel--;
                       // ship.setBounds(ship.getX() , ship.getY() - 10, shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX(), centerPoint.getY() - centerPointSpeed, sizeOfNucleus, sizeOfNucleus);
                    }
		}
                if(k == e.VK_DOWN){
                        if(space.Space.thereIsAShip){
                        ship.yVel++;
                        //ship.setBounds(ship.getX() , ship.getY() + 10, shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX(), centerPoint.getY() + centerPointSpeed, sizeOfNucleus, sizeOfNucleus);
                    }
		}
			
		
                if(k == e.VK_LEFT){
                            if(space.Space.thereIsAShip){
                        ship.xVel--;
                        //ship.setBounds(ship.getX() - 10, ship.getY(), shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX() - centerPointSpeed, centerPoint.getY(), sizeOfNucleus, sizeOfNucleus);
		}
                   
                }
		
		if(k == e.VK_RIGHT){
                               if(space.Space.thereIsAShip){
                        ship.xVel++;
                      //  ship.setBounds(ship.getX() + 10, ship.getY(), shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX() + centerPointSpeed, centerPoint.getY(),sizeOfNucleus, sizeOfNucleus);
		}
                  
                }
                
                if(k == e.VK_E){
                        
                  space.Space.screen.restart();      
		}
                
                if(k == e.VK_X){
                        
                  space.Space.screen.startPanel();      
		}
                      if(k == e.VK_P){
                        
                  timer.stop();
		}
                    
                     if(k == e.VK_O){
                        
                  timer.start();
		}
                
                if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    centerPoint.setBounds(Xcord, Ycord, sizeOfNucleus, sizeOfNucleus);
		} 
                
    }

    @Override
    public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
		if(k == e.VK_UP){
                    if(space.Space.thereIsAShip){
                        ship.yVel--;
                     //   ship.setBounds(ship.getX() , ship.getY() - 10, shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX(), centerPoint.getY() - centerPointSpeed, sizeOfNucleus, sizeOfNucleus);
                    }
		}
                if(k == e.VK_DOWN){
                        if(space.Space.thereIsAShip){
                        ship.yVel++;
                      //  ship.setBounds(ship.getX() , ship.getY() + 10, shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX(), centerPoint.getY() + centerPointSpeed, sizeOfNucleus, sizeOfNucleus);
                    }
		}
			
		
                if(k == e.VK_LEFT){
                            if(space.Space.thereIsAShip){
                        ship.xVel--;
                     //  ship.setBounds(ship.getX() - 10, ship.getY(), shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX() - centerPointSpeed, centerPoint.getY(), sizeOfNucleus, sizeOfNucleus);
		}
                   
                }
		
		if(k == e.VK_RIGHT){
                               if(space.Space.thereIsAShip){
                        ship.xVel++;
                     //   ship.setBounds(ship.getX() + 10, ship.getY(), shipSize, shipSize);
                    }else{
			centerPoint.setBounds(centerPoint.getX() + centerPointSpeed, centerPoint.getY(),sizeOfNucleus, sizeOfNucleus);
		}
                  
                }
                    
		
		
		
                if(k == e.VK_E){
                        
                  space.Space.screen.restart();      
		}
                
                
                 if(k == e.VK_X){
                        
                  space.Space.screen.startPanel();      
		}
                
                      if(k == e.VK_P){
                        
                  timer.stop();
		}
                    
                     if(k == e.VK_O){
                        
                  timer.start();
		}
                
                
               if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    centerPoint.setBounds(Xcord, Ycord, sizeOfNucleus, sizeOfNucleus);
		} 
                
                  if(k == e.VK_Q){
                        
                  ship.mass = 0.0;      
		}
                
                  if(k == e.VK_W){
                        
                  ship.mass = space.Space.globalShipMass;      
		}
                
                
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
 
    
    }
 
    
   
     
     public void moveParticle(ArrayList <Sbutton> electrons){
       
        
         for(int i = 0; i < electrons.size(); i++){
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       int moveX = (electrons.get(i).getX()+ (particleSize/2)) - (centerPoint.getX() + (sizeOfNucleus/2));
       int moveY = (electrons.get(i).getY()+ (particleSize/2)) - (centerPoint.getY()+ (sizeOfNucleus/2));
       // chase the tail!  this is an effect we don't have running yet
           // moveX = electrons.get(i).getX() - electrons.get(electrons.size()-1).getX();
           // moveY = electrons.get(i).getY() - electrons.get(electrons.size()-1).getY(); 
      //int amountOfForce = getDistance(electrons.get(i).getX(),electrons.get(i).getY(), centerPoint.getX(), centerPoint.getY());
      
       
                if(!space.Space.globalSingularGravity){
                        if(i > 0){
                             moveX = electrons.get(i).getX() - electrons.get(i-1).getX();
                             moveY = electrons.get(i).getY() - electrons.get(i-1).getY(); 

                           // move = enemySpeed - i;
                        }
                }
                
                
            if(space.Space.linearMovement){
                
             
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
                
                 int move = enemySpeed;
                
        if (moveX > 0){
                    if(Math.abs(moveX - move)>move){
                   electrons.get(i).setBounds(electrons.get(i).getX() - move, electrons.get(i).getY(), particleSize, particleSize); 
                    }
                }else{
                    if(Math.abs(moveX - move)>move){
                  electrons.get(i).setBounds(electrons.get(i).getX() + move, electrons.get(i).getY(), particleSize, particleSize); 
                    }
                }
                if (moveY > 0){
                    if(Math.abs(moveY - move)>move){
                   electrons.get(i).setBounds(electrons.get(i).getX(), electrons.get(i).getY() - move, particleSize, particleSize);
                    }
                }else{
                        if(Math.abs(moveY - move)>move){
                    
                  electrons.get(i).setBounds(electrons.get(i).getX(), electrons.get(i).getY() + move, particleSize, particleSize);  
                        }
                }
       
              
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } else{ 
                 double amountOfForce; 
                 
                 amountOfForce = calculateGravity(electrons.get(i).getX(),electrons.get(i).getY(), centerPoint.getX(), centerPoint.getY(), electrons.get(i).mass, centerPoint.mass);
                 
                 // check all electrons for gravity
                 double totalGravity = 0.0;
                 if(space.Space.allParticlesHaveGravity){
                
                 
                        for(int j = 0; j < electrons.size(); j++){
                                   if(i != j){ // don't calculate gravity on yourself
                                  totalGravity  = calculateGravity(electrons.get(i).getX(),electrons.get(i).getY(), electrons.get(j).getX(),electrons.get(j).getY(), electrons.get(i).mass, electrons.get(j).mass);
                                  }
                        }
                 }
                 
                // double  amountOfXForce = calculateSingleVectorGravity(electrons.get(i).getX(), centerPoint.getX(),  electrons.get(i).mass, centerPoint.mass);
               // double amountOfYForce = calculateSingleVectorGravity(electrons.get(i).getY(), centerPoint.getY(), electrons.get(i).mass, centerPoint.mass);
                
                if(!space.Space.gravityGetsStronger){
                amountOfForce = 1;
                }
                if(space.Space.showStallman){
                amountOfForce = getDistance(electrons.get(i).getX(),electrons.get(i).getY(), centerPoint.getX(), centerPoint.getY());
                }
                // first run gravity on x vector
               // amountOfForce = calculateSingleVectorGravity(electrons.get(i).getX(), centerPoint.getX(),  electrons.get(i).mass, centerPoint.mass);
                
                                    if (moveX > 0){
                                       electrons.get(i).xVel = electrons.get(i).xVel - (amountOfForce + totalGravity);
                                    }else if (moveX < 0){
                                       electrons.get(i).xVel = electrons.get(i).xVel + (amountOfForce + totalGravity);
                                    }else{
                                      // if zero, do nothing    
                                    }

                                    if (moveY > 0){
                                        electrons.get(i).yVel = electrons.get(i).yVel - (amountOfForce + totalGravity);
                                   }else if (moveY < 0){
                                       electrons.get(i).yVel = electrons.get(i).yVel + (amountOfForce + totalGravity);
                                    }else{
                                      // if zero, do nothing  
                                    }
                        
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
               
               //  electrons.get(0).setBackground(Color.WHITE);
                 
                 // electrons.get(i).xVel = electrons.get(i).xVel + getXForce(getAngleInDegrees(electrons.get(i).getX(),electrons.get(i).getY(), centerPoint.getX(), centerPoint.getY()), 1);
                  //electrons.get(i).yVel = electrons.get(i).yVel + getYForce(getAngleInDegrees(electrons.get(i).getX(),electrons.get(i).getY(), centerPoint.getX(), centerPoint.getY()), 1);
                 
                 
                 
                electrons.get(i).move();
                //electrons.get(i).checkCollision();
            }
            
           
            
            
            }  // end for loop
      
      
   }   // end move particle
   
     
 
    
    
    
    
    
    
    public double calculateGravity(int x, int y, int dx, int dy, double m1, double m2){
        
        double forceAmount = 1;
        
        
        
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
        
        double uniGravConst = space.Space.universalGravitationConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        forceAmount = gravitationalAttraction; 
        
        return forceAmount; 
       
    } //end calculate gravity
     

  
     // this is the stepped 'game gravity' that we need for the Stallman Halo. 
     //the mass sliders have been disconnected from these variables, you could make new sliders 
     //- this kind of gravity is different, might be better suited to certain game applications
    public int getDistance(int x, int y, int dx, int dy){
        
        int forceAmount = 1;
        
        
        double gravityWell = space.Space.gravityWellDistance;
        double mass = 3;//space.Space.massOfCenter;
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
      
      
        if(distance < gravityWell){
           forceAmount = (int)(mass * .2); 
        }
        if(distance < gravityWell * .9){
          forceAmount = (int)(mass * .3); 
        }
        if(distance < gravityWell * .8){
           forceAmount = (int)(mass * .4); 
        }
        if(distance < gravityWell * .7){
            forceAmount = (int)(mass * .5); 
        }
        if(distance < gravityWell * .6){
            forceAmount = (int)(mass * .6); 
        }
        if(distance < gravityWell * .5){
          forceAmount = (int)(mass * .7); 
        }
        if(distance < gravityWell * .4){
           forceAmount = (int)(mass * .8); 
        }
        if(distance < gravityWell * .3){
            forceAmount = (int)(mass * .9); 
        }
        if(distance < gravityWell * .2){
            forceAmount = (int)(mass); 
        }
        
        
        
       return forceAmount; 
    } //end get distance    
        
        
        
        
    public double calculateSingleVectorGravity(int x,  int dx,  double m1, double m2){
        // i don't know if this is anywhere near right, i think it's correct, it's my feeling - gravity should have different values on x and y
        // so if you call this on the x and y individually, it should be more accurate movement
        // i believe that we are not using trig for our solution, there probably is a sine/cosine application I haven't found yet
        double forceAmount = 1;
        
        double distance = x-dx;
        double uniGravConst = space.Space.universalGravitationConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        
        forceAmount = gravitationalAttraction; 
       
    
        return forceAmount; 
       
    } //end calculate gravity  
     
     
     
     
     
     


    @Override
    public void mouseClicked(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);      
        }else{
     centerPoint.setBounds(e.getX(), e.getY(), sizeOfNucleus, sizeOfNucleus);
        }
    // centerPoint.setBackground(Color.red);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);    
        }else{
         centerPoint.setBounds(e.getX(), e.getY(), sizeOfNucleus, sizeOfNucleus);
        }
        //  centerPoint.setBackground(Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);
        }else{
         centerPoint.setBounds(e.getX(), e.getY(), sizeOfNucleus, sizeOfNucleus);
        }
        // centerPoint.setBackground(Color.red);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 //http://stackoverflow.com/questions/20011091/move-over-a-jpanel-with-mouse-dragged
                public void mouseDragged(MouseEvent e) {
                   // Point p = e.getPoint();
                    //int x = p.x - startPoint.x;
                   // int y = p.y - startPoint.x;
                   // offset = new Point(x, y);
                     //ship.setBounds((int) me.getPoint().getX(), (int) me.getPoint().getY(), space.Space.globalShipSize, space.Space.globalShipSize);  
                   // repaint();
                }
       
      public void mouseMoved(MouseEvent me) {
   ship.setBounds((int) me.getPoint().getX(), (int) me.getPoint().getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);  
    repaint();
  }

      
      
      
      
            
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
 
     
     public void gravitationalAttration(){
     
      //  distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
       // uniGravConst = ugc * powerOfTen(powerOfTen);
      //  gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
 } 
   
 
   //http://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees
public  double getAngleInDegrees(double x, double y, double x2, double y2) {
    double angle = (double) Math.toDegrees(Math.atan2(y2 - y, x2 - x));

    if(angle < 0){
        angle += 360;
    }

    return angle;
}   
   


  // adapted from the example in the book "Beginning Java SE 6 Game Programming, third edition", by Jonathan S. Harbour 
   
 public  double getXForce(double angleInDegrees, double force){
     
     return (double)(Math.cos(angleInDegrees*Math.PI/180)) * force;
 }  
   
  public  double getYForce(double angleInDegrees, double force){
     
     return (double)(Math.sin(angleInDegrees*Math.PI/180)) * force;
 }   


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
} // end
