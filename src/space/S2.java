/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class S2 extends JPanel{
    
    
    public S2() {
        
        super();
        setLayout(new GridLayout(1,2));
        initComponents();
   
    }  // end constructor
    
   
    private void initComponents(){
     
       SliderPanel sp = new SliderPanel();
       JPanel green = new JPanel();
       sp.setBackground(Color.black);
       green.setBackground(Color.green);
       add(sp);
       add(green);
        
        
        
    } // end init components
    
} // end
