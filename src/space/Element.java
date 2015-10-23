/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class Element extends JButton{
    
    
    String elementName = "test";  
     String elementSymbol = "te";
     int elementNumber = 0; 
     double atomicMass = 0.0;
    int type = 0;
    
    JPanel infoCard;
    JLabel nameLabel;
    JLabel symbolLabel;
    JLabel elementNumberLabel;
    JLabel atomicMassLabel;
    
    
    
    
    public Element(){
        super();
        
        
    }
    
 public JPanel cardViewer(JPanel w){
     
        w = new JPanel(new GridLayout(4,1));
        nameLabel = new JLabel(elementName);
        symbolLabel = new JLabel(elementSymbol);
        elementNumberLabel = new JLabel("" + elementNumber);
        atomicMassLabel = new JLabel("" + atomicMass);
     
        w.add(nameLabel);
        w.add(symbolLabel);
        w.add(elementNumberLabel);
        w.add(atomicMassLabel);

    return infoCard; 
 }   
    
  

 
 
 
 
 
 
 
 
 
 
 
    
}  // end
