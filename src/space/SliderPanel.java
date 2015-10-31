/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mark
 */
public class SliderPanel extends JPanel implements ChangeListener{
    
      JSlider numberOfParticles;
    JSlider sizeOfParticles;
    JSlider speedOfParticles;
    JSlider speedLimitMaxOfParticles;
    JSlider speedLimitMinOfParticles;
    JSlider massOfCenter;
    
    JSlider massOfParticles;
    JSlider massOfShip;
    JSlider gravitationalConstant;
    JSlider powerOfTen;
    
    JLabel massOfShipLabel;
    JLabel gravitationalConstantLabel;
    JLabel powerOfTenLabel;
    JLabel massOfParticlesLabel;
    JLabel massOfCenterLabel;
    JLabel numOfParticles;
    JLabel speedLimitMaxOfParticlesLabel;
    JLabel sizeOfParticlesLabel;
    JLabel speedOfParticlesMaxLabel;
    JLabel speedLimitMinOfParticlesLabel;  
    
    public SliderPanel(){
        
        super();
        setLayout(new GridLayout(10,2));
        initComponents();
        
    }// end constructor
   
    
 private void initComponents(){
     
        massOfCenter = new JSlider(JSlider.HORIZONTAL, 0, 100, (int)Space.massOfCenter);
        massOfCenter.addChangeListener(this);
        massOfCenter.setBackground(Color.black);
        add(massOfCenter);
        massOfCenterLabel = new JLabel("<html><h2><font color='white'>mass of center: </font><font color='red'>" + Space.massOfCenter + "</font><h2></html>");
         add(massOfCenterLabel);
        
        
        massOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 100, (int)Space.globalParticleMass);
        massOfParticles.addChangeListener(this);
        massOfParticles.setBackground(Color.black);
        add(massOfParticles);
        massOfParticlesLabel = new JLabel("<html><h2><font color='white'>mass of particles: </font><font color='red'>" + Space.globalParticleMass + "</font><h2></html>");
        add(massOfParticlesLabel);
        
        
        massOfShip = new JSlider(JSlider.HORIZONTAL, 1, 100, (int)Space.globalParticleMass);
        massOfShip.addChangeListener(this);
        massOfShip.setBackground(Color.black);
        add(massOfShip);
        massOfShipLabel = new JLabel("<html><h2><font color='white'>mass of ship: </font><font color='red'>" + Space.globalShipMass + "</font><h2></html>");
        add(massOfShipLabel);
        
        
        gravitationalConstant = new JSlider(JSlider.HORIZONTAL, 1, 10000, Space.universalGravitationalConstant);
        gravitationalConstant.addChangeListener(this);
        gravitationalConstant.setBackground(Color.black);
        add(gravitationalConstant);
        gravitationalConstantLabel = new JLabel("<html><h2><font color='white'>Gravitational Constant: </font><font color='red'>" + Space.universalGravitationalConstant + "</font><h2></html>");
        add(gravitationalConstantLabel);
        
        
        powerOfTen = new JSlider(JSlider.HORIZONTAL, -10, 10, Space.ugcPowerOfTen);
        powerOfTen.addChangeListener(this);
        powerOfTen.setBackground(Color.black);
        add(powerOfTen);
        powerOfTenLabel = new JLabel("<html><h2><font color='white'>UGC: " + Space.universalGravitationalConstant + " x 10^</font><font color='red'>" + Space.ugcPowerOfTen + "</font><h2></html>");
        add(powerOfTenLabel);
        
        
        numberOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 10000, Space.globalAmountOfParticles);
        numberOfParticles.addChangeListener(this);
        numberOfParticles.setBackground(Color.black);
        add(numberOfParticles);
        numOfParticles = new JLabel("<html><h2><font color='white'># of particles: </font><font color='red'>" + Space.globalAmountOfParticles + "</font><h2></html>");
      //  numOfParticles.setBounds(column(2), row(6), 220, 40);
        add(numOfParticles);
        
        
        sizeOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 80, Space.globalParticleSize);
        sizeOfParticles.addChangeListener(this);
        sizeOfParticles.setBackground(Color.black);
        add(sizeOfParticles);
        sizeOfParticlesLabel = new JLabel("<html><h2><font color='white'>size: </font><font color='red'>" + Space.globalParticleSize + "</font><h2></html>");
     //   sizeOfParticlesLabel.setBounds(column(2), row(7), 220, 40);
        add(sizeOfParticlesLabel);
        
        speedOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 100, Space.globalTimerSpeed);
        speedOfParticles.addChangeListener(this);
        speedOfParticles.setBackground(Color.black);
        add(speedOfParticles);
        //speedOfParticlesMaxLabel = new JLabel("speed: " + Space.globalTimerSpeed);
        speedOfParticlesMaxLabel = new JLabel("<html><h2><font color='white'>ms per cycle: </font><font color='red'>" + Space.globalTimerSpeed + "</font><h2></html>");
     //   speedOfParticlesMaxLabel.setBounds(column(2), row(10), 220, 40);
        add(speedOfParticlesMaxLabel);
        
        
        speedLimitMaxOfParticles = new JSlider(JSlider.HORIZONTAL, Space.globalMinSpeed, 100, Space.globalSpeedlimit);
        speedLimitMaxOfParticles.addChangeListener(this);
        speedLimitMaxOfParticles.setBackground(Color.black);
        add(speedLimitMaxOfParticles);
         speedLimitMaxOfParticlesLabel = new JLabel("<html><h2><font color='white'>max speed limit: </font><font color='red'>" + Space.globalSpeedlimit + "</font><h2></html>");
    //    speedLimitMaxOfParticlesLabel.setBounds(column(2), row(8), 220, 40);
        add(speedLimitMaxOfParticlesLabel);
        
        
        speedLimitMinOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 40, Space.globalMinSpeed);
        speedLimitMinOfParticles.addChangeListener(this);
        speedLimitMinOfParticles.setBackground(Color.black);
        add(speedLimitMinOfParticles);
        speedLimitMinOfParticlesLabel = new JLabel("<html><h2><font color='white'>min speed limit: </font><font color='red'>" + Space.globalMinSpeed + "</font><h2></html>");
    //    speedLimitMinOfParticlesLabel.setBounds(column(2), row(9), 2200, 40);
        speedLimitMinOfParticlesLabel.setBackground(Color.red);
        add(speedLimitMinOfParticlesLabel); 
     
     
     
 } // end init components  
    
     @Override
        public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
       
               if (source == massOfShip) {
            Space.globalShipMass = source.getValue();
            massOfShipLabel.setText("<html><h2><font color='white'>mass of ship: </font><font color='red'>" + Space.globalShipMass + "</font><h2></html>");
        }
                      if (source == gravitationalConstant) {
            Space.universalGravitationalConstant = source.getValue();
            gravitationalConstantLabel.setText("<html><h2><font color='white'>Gravitational Constant: </font><font color='red'>" + Space.universalGravitationalConstant + "</font><h2></html>");
            // do this so that the grav const values update in the power of ten label
            powerOfTenLabel.setText("<html><h2><font color='white'>UGC: " + Space.universalGravitationalConstant + " x 10^</font><font color='red'>" + Space.ugcPowerOfTen + "</font><h2></html>");
        }
                             if (source == powerOfTen) {
            Space.ugcPowerOfTen = source.getValue();
            powerOfTenLabel.setText("<html><h2><font color='white'>UGC: " + Space.universalGravitationalConstant + " x 10^</font><font color='red'>" + Space.ugcPowerOfTen + "</font><h2></html>");
        }
        if (source == massOfCenter) {
            Space.massOfCenter = source.getValue();
            massOfCenterLabel.setText("<html><h2><font color='white'>mass of center: </font><font color='red'>" + Space.massOfCenter + "</font><h2></html>");
        }
         if (source == massOfParticles) {
            Space.globalParticleMass = source.getValue();
            massOfParticlesLabel.setText("<html><h2><font color='white'>mass of particles: </font><font color='red'>" + Space.globalParticleMass + "</font><h2></html>");
        }
        if (source == numberOfParticles) {
            Space.globalAmountOfParticles = (int)source.getValue();
            //numOfParticles.setText(Space.globalAmountOfParticles + " particles");
            numOfParticles.setText("<html><h2><font color='white'># of particles: </font><font color='red'>" + Space.globalAmountOfParticles + "</font><h2></html>");
        }
        if (source == sizeOfParticles) {
            Space.globalParticleSize  = (int)source.getValue();
            
            sizeOfParticlesLabel.setText("<html><h2><font color='white'>size: </font><font color='red'>" + Space.globalParticleSize + "</font><h2></html>");
        }
        if (source == speedOfParticles) {
            Space.globalTimerSpeed = (int)source.getValue();
            speedOfParticlesMaxLabel.setText("<html><h2><font color='white'>ms per cycle: </font><font color='red'>" + Space.globalTimerSpeed + "</font><h2></html>");
        }
        if (source == speedLimitMaxOfParticles) {
            Space.globalSpeedlimit = (int)source.getValue();
            speedLimitMaxOfParticlesLabel.setText("<html><h2><font color='white'>max speed limit: </font><font color='red'>" + Space.globalSpeedlimit + "</font></h2></html>");
        }
         if (source == speedLimitMinOfParticles) {
            Space.globalMinSpeed = (int)source.getValue();
            speedLimitMinOfParticlesLabel.setText("<html><h2><font color='white'>min speed limit: </font><font color='red'>" + Space.globalMinSpeed + "</font></h2></html>");
        }
    } // end state changed

  
        
                //////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
}  // end
