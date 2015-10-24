/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class ElementViewer extends JPanel{
   
    
    PeriodicTable pt;
    
    
    
    public ElementViewer(){
            super();
       setLayout(null);
       setBackground(Color.red);
            pt = new PeriodicTable();
           
            pt.setBounds(0, 0, (int)space.Space.width, (int)space.Space.height);
             add(pt);
             
    }
    
    
    

    
    
                 //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
private int row(int r){
    int pixelNumber = ((r-1)*(int)(space.Space.height/16))+20;
    return pixelNumber;
}   

private int column(int c){ 
    int columnPixelNumber = 0;
    
    switch(c){  // these arent in cardinal order, i've been readjusting layouts
        //case 1: columnPixelNumber = (space.Space.width/8)*1; break;
            
                case 1: columnPixelNumber   = (int)(space.Space.width*.02); break;
                case 2: columnPixelNumber   = (int)(space.Space.width*.22); break;
                case 3: columnPixelNumber   = (int)(space.Space.width*.32); break;
                case 4: columnPixelNumber   = (int)(space.Space.width*.42); break;
                case 5: columnPixelNumber   = (int)(space.Space.width*.52); break;
                case 6: columnPixelNumber   = (int)(space.Space.width*.62); break;
    }
    return columnPixelNumber;
} // end column
    

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    
    
}
