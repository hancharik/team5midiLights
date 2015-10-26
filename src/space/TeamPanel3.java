/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class TeamPanel3 extends JPanel implements ActionListener, KeyListener, MouseListener {
    
    
    
       
    //@see http://stackoverflow.com/questions/7456227 
        private static final String abstractActionString = "close";
    ///////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    private Action nameOfActionVariable = new AbstractAction(abstractActionString) {

            @Override
            public void actionPerformed(ActionEvent e) {
                space.Space.f.dispatchEvent(new WindowEvent(
                    space.Space.f, WindowEvent.WINDOW_CLOSING));
            }
        };
    private JButton b = new JButton(nameOfActionVariable);

        
        
       
    
    
    
    
    
    
    
    int playerSize = space.Space.globalParticleSize;
    int amountOfEnemies;// = space.Space.globalAmountOfEnemies;
    int helioSize = space.Space.globalHelioSize;
   
    
    int enemySpeed = space.Space.globalEnemySpeed;
    
    int helioSpeed = 10;
    int timerSpeed = space.Space.globalTimerSpeed;
    int theGlobalSpeedLimit = space.Space.globalSpeedlimit;// + helioSize;// douglas adams is max
    int minSpeed = space.Space.globalMinSpeed;
    Sbutton helio;
    Sbutton ship;
    ArrayList<Sbutton> particles;// = new ArrayList();
    int screenWidth;
    int screenHeight;
  
    
    Timer timer;
    boolean singularGravity = true;
    
    
    int Xcord;// = (int) (Math.random() * 400) + 1;
    int Ycord;/// = (int) (Math.random() * 340) + 1;
    
    
    JPanel infoCard;
    JLabel xVelocityLabel;
    JLabel yVelocityLabel;
    JLabel xPositionLabel;
    JLabel yPositionLabel;
    JLabel massLabel;
    
    double xVelocityDouble;
    double yVelocityDouble; 
    
    
    
    
    
    
    
    
    
    
    
    public TeamPanel3(){
       
        
        
        
          
       
     
    
       
       
       
       
        
        
        
        
        
        
        
        
       super();
       
       setLayout(null);
       setBackground(Color.black);
       
       
       
       
       
         // this.add(b);
        
        
       // space.Space.f.getRootPane().setDefaultButton(b);
        
  
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), abstractActionString);
        
     
        
        
        this.getActionMap().put(abstractActionString, nameOfActionVariable);
       
       
       
       
       
       
       
       
       
       
       addMouseListener(this);
       setVariables();
        
      
      
        particles = new ArrayList();
        addHelio();
        particles.add(helio);
        addParticles();
      
  
        xVelocityLabel = new JLabel("X Velocity = " + xVelocityDouble);
        yVelocityLabel = new JLabel("Y Velocity = " + yVelocityDouble);
        xVelocityLabel.setBounds(20, 20, 200, 40);
        yVelocityLabel.setBounds(20, 70, 200, 40);
        xVelocityLabel.setVisible(false);
        yVelocityLabel.setVisible(false);
        add(xVelocityLabel);
        add(yVelocityLabel);
        
        xPositionLabel = new JLabel("X Position = (" + xVelocityDouble + "," + yVelocityDouble + ")");
        yPositionLabel = new JLabel("Y Position = (" + xVelocityDouble + "," + yVelocityDouble + ")");
        xPositionLabel.setBounds(20, 130, 200, 40);
        yPositionLabel.setBounds(20, 70, 200, 40);
        xPositionLabel.setVisible(false);
        yPositionLabel.setVisible(false);
        add(xPositionLabel);
        //add(yPositionLabel);
        
        massLabel = new JLabel("X Velocity = " + xVelocityDouble);
        massLabel.setBounds(20, 180, 200, 40);
        massLabel.setVisible(false);
        add(massLabel);
        
       /// makeCardPanel();
       // infoCard.setVisible(false);
       // add(infoCard);
        
        
        
        
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
      // if we have this, do we need the stuff at the bottom?
      addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
                                    if(space.Space.thereIsAShip){
                                        ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);   
                                        ship.xVel = 0.0;
                                        ship.yVel = 0.0;
                                           }else{
                                        helio.setBounds(e.getX(), e.getY(), helioSize, helioSize);
                                            }
                                    }
                                });
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
      
 
       timer = new Timer( timerSpeed, this);
       timer.start();
       helio.requestFocus();
       //requestFocus();
    }  // end constructor
 
    
    
    
    
    public void setVariables(){
        
        singularGravity = space.Space.globalSingularGravity;
          playerSize = space.Space.globalParticleSize;
   amountOfEnemies= space.Space.globalAmountOfParticles;
     helioSize = space.Space.globalHelioSize;
     //int helioSize = amountOfEnemies;
    
     enemySpeed = space.Space.globalEnemySpeed;
    
    helioSpeed = 10;
    timerSpeed = space.Space.globalTimerSpeed;//  42 is good viewing (24 fps?)
     theGlobalSpeedLimit = space.Space.globalSpeedlimit;// + helioSize;
     minSpeed = space.Space.globalMinSpeed;
     
     screenWidth = (int)space.Space.width;
    screenHeight = (int)space.Space.height;
     
     
     
     
    }  // end set variables 
    
    
    
    public void addHelio(){
        
        if(space.Space.thereIsAShip){
            ship = new Sbutton();
            ship.setBounds(20, 20, space.Space.globalShipWidth, space.Space.globalShipHeight);
            ship.setBackground(Color.GRAY);
            ship.addActionListener(this);
            ship.addKeyListener(this);
            ship.speedLimit = space.Space.globalShipSpeedLimit;
            ship.xVel = 5.0;
            ship.yVel = 5.0;
            particles.add(ship);  // this is how we add movement, we just add the ship to the particle array and it gets moved when all of the other particles get moved
            //ship.makeShip(1, 1);// first 1 is type (1=="ufo"), second 1 is id number
            add(ship);
      }
        
        Xcord = (screenWidth/2);
        Ycord = (screenHeight/2);
         //helioSize = space.Space.globalHelioSize;
         
        helio = new Sbutton();
        helio.setBounds(Xcord, Ycord, helioSize, helioSize);
        helio.setBackground(Color.YELLOW);
        helio.addActionListener(this);
        helio.addKeyListener(this);
        if(space.Space.showStallman){
            helioSize = space.Space.globalStallmanSize;
        helio.makeHero();
        
        }
        helio.setBounds(Xcord, Ycord, helioSize, helioSize);
        helio.mass = space.Space.massOfCenter;
        add(helio);   
    }
  
    
    
   //////////////////////////////////////////////////////////////////////////////////////
    
    
      public void addParticles(){
          
          amountOfEnemies = space.Space.globalAmountOfParticles;
         
         for(int i = 0; i < amountOfEnemies; i++){
             Xcord = helio.getX() - ((int)(Math.random() * 200) + 1);//(int) (Math.random() * (space.Space.screen.width-300)) + 200;
         Ycord = helio.getY() - ((int)(Math.random() * 100) + 100);//(int) (Math.random() * (space.Space.screen.height-300)) + 200;
         //int xsp = 30;
         //int ysp = -10;
         // this is our cast, we "throw" them to try to get an orbit
         int xsp = 20;
         int ysp = -1;
         
         
         if(space.Space.particles){
            Xcord = (int) (Math.random() * (screenWidth)) + 1;
            Ycord = (int) (Math.random() * (screenHeight)) + 1;  
            xsp = 0;
            ysp = 0;
         }
         
         
         
        Sbutton a = new Sbutton();
         
        
        a.setBounds(Xcord, Ycord, playerSize, playerSize);
        a.setBackground(Color.red);
        a.xVel = xsp;
        a.yVel = ysp;
        a.mass = space.Space.globalParticleMass;
        a.addActionListener(this);
        a.speedLimit = (int)(Math.random() * theGlobalSpeedLimit) + minSpeed;
        a.setColor();
        a.setBorderPainted(false);
         particles.add(a);
        add(a);   
        
         }
    }  // end add particles
 
      
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
      
      
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == timer){


                    moveParticle();


                }else if (obj == helio){
                    
                    timer.stop();
                  
                    space.Space.screen.startPanel();
                  
                }else{
        
        
        	for(int k = 0; k < particles.size(); k++){
                    
                
                
                            if (obj == particles.get(k)){
                                
                                
                                //xVelocityDouble = particles.get(k).xVel;
                                //yVelocityDouble = particles.get(k).yVel;
                                xVelocityLabel.setText("<html><h2><font color='white'>X Velocity = </font><font color='red'>" + particles.get(k).xVel + "</font><h2></html>");
                                yVelocityLabel.setText("<html><h2><font color='white'>Y Velocity = </font><font color='red'>" + particles.get(k).yVel + "</font><h2></html>");
                                xVelocityLabel.setVisible(true);
                                yVelocityLabel.setVisible(true);
                                xPositionLabel.setText("<html><h2><font color='white'>Position = </font><font color='red'>" + "(" + particles.get(k).getX() + "," + particles.get(k).getY() + ")" + "</font><h2></html>");
                                yPositionLabel.setText("<html><h2><font color='white'>Y Position = </font><font color='red'>" + particles.get(k).getX() + "</font><h2></html>");
                                xPositionLabel.setVisible(true);
                               // yPositionLabel.setVisible(true);
                                massLabel.setText("<html><h2><font color='white'>Mass = </font><font color='red'>" + particles.get(k).mass + "</font><h2></html>");
                                massLabel.setVisible(true);
                                helio.requestFocus();  //   <-- because helio has the key listener
                                           
                               // space.Space.screen.elementViewerPanel();  
  
                            }  // enf if obj == elements.get(k)
  
                }
  
        }
    
    } // end action performed
         
         
         
         
         
         

    @Override  // I DON'T THINK WE NEED THIS ONE, I DON'T THINK IT WORKS
    public void keyTyped(KeyEvent e) {
        int k = e.getKeyCode();
		if(k == e.VK_UP){
                    if(space.Space.thereIsAShip){
                        ship.yVel--;
                       // ship.setBounds(ship.getX() , ship.getY() - 10, shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX(), helio.getY() - helioSpeed, helioSize, helioSize);
                    }
		}
                if(k == e.VK_DOWN){
                        if(space.Space.thereIsAShip){
                        ship.yVel++;
                        //ship.setBounds(ship.getX() , ship.getY() + 10, shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX(), helio.getY() + helioSpeed, helioSize, helioSize);
                    }
		}
			
		
                if(k == e.VK_LEFT){
                            if(space.Space.thereIsAShip){
                        ship.xVel--;
                        //ship.setBounds(ship.getX() - 10, ship.getY(), shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX() - helioSpeed, helio.getY(), helioSize, helioSize);
		}
                   
                }
		
		if(k == e.VK_RIGHT){
                               if(space.Space.thereIsAShip){
                        ship.xVel++;
                      //  ship.setBounds(ship.getX() + 10, ship.getY(), shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX() + helioSpeed, helio.getY(),helioSize, helioSize);
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
                    xVelocityLabel.setVisible(false);
                    yVelocityLabel.setVisible(false);  
                    xPositionLabel.setVisible(false);
                    yPositionLabel.setVisible(false);
                    massLabel.setVisible(false);
                    
                    timer.start();
		}
                
                if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    helio.setBounds(Xcord, Ycord, helioSize, helioSize);
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
			helio.setBounds(helio.getX(), helio.getY() - helioSpeed, helioSize, helioSize);
                    }
		}
                if(k == e.VK_DOWN){
                        if(space.Space.thereIsAShip){
                        ship.yVel++;
                      //  ship.setBounds(ship.getX() , ship.getY() + 10, shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX(), helio.getY() + helioSpeed, helioSize, helioSize);
                    }
		}
			
		
                if(k == e.VK_LEFT){
                            if(space.Space.thereIsAShip){
                        ship.xVel--;
                     //  ship.setBounds(ship.getX() - 10, ship.getY(), shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX() - helioSpeed, helio.getY(), helioSize, helioSize);
		}
                   
                }
		
		if(k == e.VK_RIGHT){
                               if(space.Space.thereIsAShip){
                        ship.xVel++;
                     //   ship.setBounds(ship.getX() + 10, ship.getY(), shipSize, shipSize);
                    }else{
			helio.setBounds(helio.getX() + helioSpeed, helio.getY(),helioSize, helioSize);
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
                    xVelocityLabel.setVisible(false);
                    yVelocityLabel.setVisible(false);  
                    xPositionLabel.setVisible(false);
                    yPositionLabel.setVisible(false);
                    massLabel.setVisible(false);   
                    timer.start();
		}
                     
                     
               if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    helio.setBounds(Xcord, Ycord, helioSize, helioSize);
		} 
                
                  if(k == e.VK_Q){
                        
                  ship.mass = 0.0;   
                  ship.setBackground(Color.BLUE);
		}
                
                  if(k == e.VK_W){
                        
                  ship.mass = space.Space.globalShipMass;  
                  ship.setBackground(Color.GRAY);
		}
                
                
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
 
    
    }
 
    

    
    
    
    
     
     public void moveParticle(){
       
         
         for(int i = 0; i < particles.size(); i++){
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       int moveX = (particles.get(i).getX()+ (playerSize/2)) - (helio.getX() + (helioSize/2));
       int moveY = (particles.get(i).getY()+ (playerSize/2)) - (helio.getY()+ (helioSize/2));
       // chase the tail!  this is an effect we don't have running yet
           // moveX = particles.get(i).getX() - particles.get(particles.size()-1).getX();
           // moveY = particles.get(i).getY() - particles.get(particles.size()-1).getY(); 
      //int amountOfForce = getDistance(particles.get(i).getX(),particles.get(i).getY(), helio.getX(), helio.getY());
      
       
                if(!space.Space.globalSingularGravity){
                        if(i > 0){
                             moveX = particles.get(i).getX() - particles.get(i-1).getX();
                             moveY = particles.get(i).getY() - particles.get(i-1).getY(); 

                           // move = enemySpeed - i;
                        }
                }
                
                
            if(space.Space.linearMovement){
                
             
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
                
                 int move = enemySpeed;
                
        if (moveX > 0){
                    if(Math.abs(moveX - move)>move){
                   particles.get(i).setBounds(particles.get(i).getX() - move, particles.get(i).getY(), playerSize, playerSize); 
                    }
                }else{
                    if(Math.abs(moveX - move)>move){
                  particles.get(i).setBounds(particles.get(i).getX() + move, particles.get(i).getY(), playerSize, playerSize); 
                    }
                }
                if (moveY > 0){
                    if(Math.abs(moveY - move)>move){
                   particles.get(i).setBounds(particles.get(i).getX(), particles.get(i).getY() - move, playerSize, playerSize);
                    }
                }else{
                        if(Math.abs(moveY - move)>move){
                    
                  particles.get(i).setBounds(particles.get(i).getX(), particles.get(i).getY() + move, playerSize, playerSize);  
                        }
                }
       
              
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } else{ 
                 double amountOfForce; 
                 
                 amountOfForce = calculateGravity(particles.get(i).getX(),particles.get(i).getY(), helio.getX(), helio.getY(), particles.get(i).mass, helio.mass);
                 
                 // check all particles for gravity
                 double totalGravity = 0.0;
                 if(space.Space.allParticlesHaveGravity){
                
                 
                        for(int j = 0; j < particles.size(); j++){
                                   if(i != j){ // don't calculate gravity on yourself
                                  totalGravity  = calculateGravity(particles.get(i).getX(),particles.get(i).getY(), particles.get(j).getX(),particles.get(j).getY(), particles.get(i).mass, particles.get(j).mass);
                                  }
                        }
                 }
                 
                // double  amountOfXForce = calculateSingleVectorGravity(particles.get(i).getX(), helio.getX(),  particles.get(i).mass, helio.mass);
               // double amountOfYForce = calculateSingleVectorGravity(particles.get(i).getY(), helio.getY(), particles.get(i).mass, helio.mass);
                 
                if(!space.Space.gravityGetsStronger){
                amountOfForce = 1;
                }
                if(space.Space.showStallman){
                amountOfForce = getDistance(particles.get(i).getX(),particles.get(i).getY(), helio.getX(), helio.getY());
                }
                // first run gravity on x vector
               // amountOfForce = calculateSingleVectorGravity(particles.get(i).getX(), helio.getX(),  particles.get(i).mass, helio.mass);
                
                
                
                
                
                
                
                
                
                
                
                if(space.Space.trigonometricMovement){
                    
                    
                       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                   
                                       particles.get(i).xVel = particles.get(i).xVel + calculateGravityForX(particles.get(i).getX(),particles.get(i).getY(), helio.getX(), helio.getY(), particles.get(i).mass, helio.mass);
                                    
                                       particles.get(i).yVel = particles.get(i).yVel + calculateGravityForY(particles.get(i).getX(),particles.get(i).getY(), helio.getX(), helio.getY(), particles.get(i).mass, helio.mass);
                                 
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
              
                
                }else{
                    
                    
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    if (moveX > 0){
                                       particles.get(i).xVel = particles.get(i).xVel - (amountOfForce + totalGravity);
                                    }else if (moveX < 0){
                                       particles.get(i).xVel = particles.get(i).xVel + (amountOfForce + totalGravity);
                                    }else{
                                      // if zero, do nothing    
                                    }

                                    if (moveY > 0){
                                        particles.get(i).yVel = particles.get(i).yVel - (amountOfForce + totalGravity);
                                   }else if (moveY < 0){
                                       particles.get(i).yVel = particles.get(i).yVel + (amountOfForce + totalGravity);
                                    }else{
                                      // if zero, do nothing  
                                    }
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
               
                    }
                
                
                
                
                
                
                
                
               //  particles.get(0).setBackground(Color.WHITE);
                particles.get(i).move();
              
                //particles.get(i).checkCollision();
            }
            
           
            
            
            }  // end for loop
      
      
   }   // end move particle
   
     
 
    
    
    
    // i haven't tried, but can we try calling a method in the whatchamacallit?:
     //public double calculateGravity(getDistance(int x, int y, int dx, int dy), double m1, double m2){
    
    
    public double calculateGravity(int x, int y, int dx, int dy, double m1, double m2){
        
        double forceAmount = 1;
        
        
        
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
        
        double uniGravConst = space.Space.universalGravitationalConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        forceAmount = gravitationalAttraction; 
        
        return forceAmount; 
       
    } //end calculate gravity
     
     
        public double calculateGravityForX(int x, int y, int dx, int dy, double m1, double m2){
        
        double forceAmount = 1;
        
        
        
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
        
        double uniGravConst = space.Space.universalGravitationalConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        forceAmount = (gravitationalAttraction * getXForce(getAngleInDegrees(x,y,dx,dy), gravitationalAttraction)); 
        
        return forceAmount; 
       
    } //end calculate gravity for x
        
       public double calculateGravityForY(int x, int y, int dx, int dy, double m1, double m2){
        
        double forceAmount = 1;
        
        
        
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
        
        double uniGravConst = space.Space.universalGravitationalConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        forceAmount = (gravitationalAttraction * getYForce(getAngleInDegrees(x,y,dx,dy), gravitationalAttraction)); 
        
        return forceAmount; 
       
    } //end calculate gravity for y
         
     
  
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
        double uniGravConst = space.Space.universalGravitationalConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        
        forceAmount = gravitationalAttraction; 
       
    
        return forceAmount; 
       
    } //end calculate gravity  
     
     
     
     
     
     


    @Override
    public void mouseClicked(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);      
        }else{
     helio.setBounds(e.getX(), e.getY(), helioSize, helioSize);
        }
    // helio.setBackground(Color.red);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);    
        }else{
         helio.setBounds(e.getX(), e.getY(), helioSize, helioSize);
        }
        //  helio.setBackground(Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(space.Space.thereIsAShip){
     ship.setBounds(e.getX(), e.getY(), space.Space.globalShipWidth, space.Space.globalShipHeight);
        }else{
         helio.setBounds(e.getX(), e.getY(), helioSize, helioSize);
        }
        // helio.setBackground(Color.red);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
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

 
      
      
      
      
      
      
    public void makeCardPanel(){
        
        infoCard = new JPanel( new GridLayout(1,2));
        infoCard.setBounds(20, 20, 200, 300);
        infoCard.addKeyListener(this);
        infoCard.setBackground(Color.white);
        xVelocityLabel = new JLabel("X Velocity = " + xVelocityDouble);
        yVelocityLabel = new JLabel("Y Velocity = " + yVelocityDouble);
      
        infoCard.add(xVelocityLabel);
        infoCard.add(xVelocityLabel);
        
        
    }  
      
      
      
      
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
      
        
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
   
 public double getXForce(double angleInDegrees, double force){
     
     return (double)(Math.cos(angleInDegrees*Math.PI/180)) * force;
 }  
   
  public double getYForce(double angleInDegrees, double force){
     
     return (double)(Math.sin(angleInDegrees*Math.PI/180)) * force;
 }   


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    
      
     ////////////////////////////////////////////////////////////////////////////////////////////////////////   
/** @see http://stackoverflow.com/questions/7456227 */
    public void display() {
        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice dev = env.getDefaultScreenDevice();
        space.Space.f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        space.Space.f.setBackground(Color.darkGray);
        space.Space.f.setResizable(false);
        space.Space.f.setUndecorated(true);
        space.Space.f.add(this);
        space.Space.f.pack();
        dev.setFullScreenWindow(space.Space.f);
    }  // end display
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
        
        
            
      
      
      
      
      
      
      
      
      
      
      
}  // end
