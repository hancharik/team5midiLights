/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class PeriodicTable extends JPanel implements ActionListener{
    
    
    JPanel e1;
    JPanel e2;
    JPanel cardHolder;
    Atom a;
    ArrayList<Element> elements = new ArrayList(); 
     ArrayList<Integer> periodicTableChartNumbers = new ArrayList();
    
        JLabel nameLabel;
    JLabel symbolLabel;
    JLabel elementNumberLabel;
    JLabel atomicMassLabel; 
     
    JButton backButton; 
    JButton showCardsButton;
    
    
     boolean cardHolderShowing = true;
     
     
     
     
     
     
    public PeriodicTable(){
        
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        
        
        
        
        
       createArrayWithGaps();
       
       
       
       
       backButton = new JButton("Back"); 
       backButton.setBounds(column(1), row(12), 120, 40);
       backButton.addActionListener(this);
       add(backButton);
       
       
       showCardsButton = new JButton("Hide Card"); 
       showCardsButton.setBounds(column(1), row(10), 120, 40);
       showCardsButton.addActionListener(this);
       //add(showCardsButton);
       
        a = new Atom();
        a.setLayout(null);
        a.setBounds(column(42), row(1), (int)(space.Space.width*.36), (int)(space.Space.height*.36));
        setAtomVariables();
        //a.setBounds(column(1), row(6), (int)(space.Space.width*.12), (int)(space.Space.height*.23));
       //a.setBackground(Color.red); // for testing
        //a.setVisible(false);  // turn this visible for testing purposes only
        if(space.Space.showCards){
       add(a);
       }
       
       
        cardHolder = new JPanel();
        cardHolder.setLayout(null);
                nameLabel = new JLabel("name");
                symbolLabel = new JLabel("symbol");
                elementNumberLabel = new JLabel("number");
                atomicMassLabel = new JLabel("mass");
                
                
                nameLabel.setBounds(68, 160, (int)(space.Space.width*.06), (int)(space.Space.height*.03));
                symbolLabel.setBounds(100, 90, (int)(space.Space.width*.06), (int)(space.Space.height*.06));
                elementNumberLabel.setBounds(20, 0, (int)(space.Space.width*.06), (int)(space.Space.height*.06));
                atomicMassLabel.setBounds(90, 210, (int)(space.Space.width*.06), (int)(space.Space.height*.03));
                cardHolder.add(symbolLabel);
                cardHolder.add(nameLabel);
                cardHolder.add(elementNumberLabel);
                cardHolder.add(atomicMassLabel);
                
                
                
                                                cardHolder.setBackground(Color.white);
                                                
                                                //cardHolder.setVisible(true);
                
                
                
                
       cardHolder.setBounds(column(1), row(2), (int)(space.Space.width*.12), (int)(space.Space.height*.23));
      // cardHolder.setBackground(Color.red);
       //cardHolder.setVisible(false);  // turn this visible for testing purposes only
       if(space.Space.showCards){
       add(cardHolder);
       }
       
       
        e1 = new JPanel(); 
        e1.setLayout(new GridLayout(7,18));
        e1.setBackground(Color.BLACK);
        e1.setBounds(column(2), row(4), (int)(space.Space.width*.7), (int)(space.Space.height*.44));
        fillChart((7*18), e1);
        add(e1);
        
        e2 = new JPanel(); 
        e2.setLayout(new GridLayout(2,15));
        e2.setBounds(column(3), row(11), (int)(space.Space.width*.52), (int)(space.Space.height*.12));
        e2.setBackground(Color.BLACK);
        fillBottomChart( e2);
        add(e2);
         
        
        
        colorChart();
    
        
                                            symbolLabel.setText("<html><h1><center>" + space.Space.globalElementSymbol +"<center></h1></html>");
                                                nameLabel.setText("<html><h2>" +space.Space.globalElementName +"</h2></html>");
                                                elementNumberLabel.setText("<html><h1>" +space.Space.globalElementNumber +"</h1></html>");
                                                atomicMassLabel.setText("<html><h3>" +space.Space.globalAtomicMass+"</h3></html>");
        
    }  // end constructor
    
    
    
    
    
    
 public void fillChart(int x, JPanel p){   
    
    for(int i = 0; i < x; i++){
        Element b = new Element();
      //  b.addActionListener(this);
       getElement(periodicTableChartNumbers.get(i), b);
       //b.setText("s" + i);
        if(periodicTableChartNumbers.get(i)==0){
        b.setVisible(false);
        }else{
         b.setBackground(Color.WHITE);   
        }
        p.add(b);
        elements.add(b);
    }
    
 } 
   
 /* fillTopChart(0, e1, 125);
 
  public void fillTopChart(int x, JPanel p, int size){   
    
    for(int i = x; i < size; i++){
        Element b = new Element();
       
       getElement(elements.get(i).elementNumber, b);
       //b.setText("s" + i);
        
        b.setBackground(Color.blue);
        
        p.add(b);
    }
    
 } 
 */
  
    public void fillBottomChart( JPanel p){   
    
            for(int i = 57; i < 72; i++){

                Element b = new Element();
                getElement(i, b);
                b.setBackground(Color.YELLOW);
                elements.add(b);
                p.add(b);
            }
                for(int i = 89; i < 104; i++){
                Element b = new Element();
                getElement(i, b);
                elements.add(b); 
                p.add(b);

            }
 }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    // HUGE thanks to http://sciencenotes.org/wp-content/uploads/2014/05/SciNotesPeriodicTable.png for our template here...
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
   public void getElement(int e, Element jb){

     String elementName = "freesoftwarium";  
     String elementSymbol = ":D";
     int elementNumber = 0; 
     double atomicMass = 0.0;
      int family = 0; 
       switch(e){
           
            case 1 :  elementName = "Hydrogen"; elementSymbol = "H"; elementNumber = e; family = 1; atomicMass = 1.008; break;
            case 2 :  elementName = "Helium"; elementSymbol = "He"; elementNumber = e; family = 8; atomicMass = 4.003; break;
            case 3 :  elementName = "Lithium"; elementSymbol = "Li"; elementNumber = e; family = 2; break;
            case 4 :  elementName = "Beryllium"; elementSymbol = "Be"; elementNumber = e; family = 3; break;
            case 5 :  elementName = "Boron"; elementSymbol = "B"; elementNumber = e; family = 6; break;
            case 6 :  elementName = "Carbon"; elementSymbol = "C"; elementNumber = e; family = 1; break;
            case 7 :  elementName = "Nitrogen"; elementSymbol = "N"; elementNumber = e; family = 1; break;
            case 8 :  elementName = "Oxygen"; elementSymbol = "O"; elementNumber = e; family = 1; break;
            case 9 :  elementName = "Flourine"; elementSymbol = "F"; elementNumber = e; family = 7; break;
            case 10 :  elementName = "Neon"; elementSymbol = "Ne"; elementNumber = e; family = 8; break;
	    case 11 :  elementName = "Sodium"; elementSymbol = "Na"; elementNumber = e; family = 2; break;
            case 12 :  elementName = "Magnesium"; elementSymbol = "Mg"; elementNumber = e; family = 3; break;
            case 13 :  elementName = "Aluminum"; elementSymbol = "Al"; elementNumber = e; family = 5; break;
            case 14 :  elementName = "Silicon"; elementSymbol = "Si"; elementNumber = e; family = 6; break;
            case 15 :  elementName = "Phosphorus"; elementSymbol = "P"; elementNumber = e; family = 1; break;
            case 16 :  elementName = "Sulphur"; elementSymbol = "S"; elementNumber = e; family = 1; break;
            case 17 :  elementName = "Chlorine"; elementSymbol = "Cl"; elementNumber = e; family = 7; break;
            case 18 :  elementName = "Argon"; elementSymbol = "Ar"; elementNumber = e; family = 8; break;
            case 19 :  elementName = "Potassium"; elementSymbol = "K"; elementNumber = e; family = 2; break;
	    case 20 :  elementName = "Calcium"; elementSymbol = "Ca"; elementNumber = e; family = 3; break;
	    case 21 :  elementName = "Scandium"; elementSymbol = "Sc"; elementNumber = e; family = 4; break;
            case 22 :  elementName = "Titanium"; elementSymbol = "Ti"; elementNumber = e; family = 4; break;
            case 23 :  elementName = "Vanadium"; elementSymbol = "V"; elementNumber = e;  family = 4; break;
            case 24 :  elementName = "Chromium"; elementSymbol = "Cr"; elementNumber = e; family = 4; break;
            case 25 :  elementName = "Manganese"; elementSymbol = "Mn"; elementNumber = e;  family = 4; break;
            case 26 :  elementName = "Iron"; elementSymbol = "Fe"; elementNumber = e;  family = 4; break;
            case 27 :  elementName = "Cobalt"; elementSymbol = "Co"; elementNumber = e;  family = 4; break;
            case 28 :  elementName = "Nickel"; elementSymbol = "Ni"; elementNumber = e;  family = 4; break;
            case 29 :  elementName = "Copper"; elementSymbol = "Cu"; elementNumber = e;  family = 4; break;
	    case 30 :  elementName = "Zinc"; elementSymbol = "Zn"; elementNumber = e;  family = 4; break;
	    case 31 :  elementName = "Gallium"; elementSymbol = "Ga"; elementNumber = e; family = 5; break;
            case 32 :  elementName = "Germanium"; elementSymbol = "Ge"; elementNumber = e; family = 6; break;
            case 33 :  elementName = "Arsenic"; elementSymbol = "As"; elementNumber = e; family = 6; break;
            case 34 :  elementName = "Selenium"; elementSymbol = "Se"; elementNumber = e; family = 1; break;
            case 35 :  elementName = "Bromine"; elementSymbol = "Br"; elementNumber = e; family = 7; break;
            case 36 :  elementName = "Krypton"; elementSymbol = "Kr"; elementNumber = e; family = 8; break;
            case 37 :  elementName = "Rubidium"; elementSymbol = "Rb"; elementNumber = e; family = 2; break;
            case 38 :  elementName = "Strontium"; elementSymbol = "Sr"; elementNumber = e;  family = 3; break;
            case 39 :  elementName = "Yttrium"; elementSymbol = "Y"; elementNumber = e;  family = 4; break;
	    case 40 :  elementName = "Zirconium"; elementSymbol = "Zr"; elementNumber = e;  family = 4; break;
	    case 41 :  elementName = "Niobium"; elementSymbol = "Nb"; elementNumber = e;  family = 4; break;
            case 42 :  elementName = "Molbydenum"; elementSymbol = "Mo"; elementNumber = e;  family = 4; break;
            case 43 :  elementName = "Technetium"; elementSymbol = "Tc"; elementNumber = e;  family = 4; break;
            case 44 :  elementName = "Ruthenium"; elementSymbol = "Ru"; elementNumber = e;  family = 4; break;
            case 45 :  elementName = "Rhodium"; elementSymbol = "Rh"; elementNumber = e;  family = 4; break;
            case 46 :  elementName = "Palladium"; elementSymbol = "Pd"; elementNumber = e;  family = 4; break;
            case 47 :  elementName = "Silver"; elementSymbol = "Ag"; elementNumber = e;  family = 4; break;
            case 48 :  elementName = "Cadmium"; elementSymbol = "Cd"; elementNumber = e;  family = 4; break;
            case 49 :  elementName = "Indium"; elementSymbol = "In"; elementNumber = e; family = 5; break;
	    case 50 :  elementName = "Tin"; elementSymbol = "Sn"; elementNumber = e; family = 5; break;
	    case 51 :  elementName = "Antimony"; elementSymbol = "Sb"; elementNumber = e; family = 6; break;
            case 52 :  elementName = "Tellurium"; elementSymbol = "Te"; elementNumber = e; family = 6; break;
            case 53 :  elementName = "Iodine"; elementSymbol = "I"; elementNumber = e; family = 7; break;
            case 54 :  elementName = "Xenon"; elementSymbol = "Xe"; elementNumber = e; family = 8; break;
            case 55 :  elementName = "Cesium"; elementSymbol = "Cs"; elementNumber = e; family = 2; break;
            case 56 :  elementName = "Barium"; elementSymbol = "Ba"; elementNumber = e;  family = 3; break;
            case 57 :  elementName = "Lanthanum"; elementSymbol = "La"; elementNumber = e; family = 9; break;
            case 58 :  elementName = "Cerium"; elementSymbol = "Ce"; elementNumber = e; family = 9; break;
            case 59 :  elementName = "Praseodymium"; elementSymbol = "Pr"; elementNumber = e; family = 9; break;
	    case 60 :  elementName = "Neodymium"; elementSymbol = "Nd"; elementNumber = e; family = 9; break;
            case 61 :  elementName = "Promethium"; elementSymbol = "Pm"; elementNumber = e; family = 9; break;
            case 62 :  elementName = "Samarium"; elementSymbol = "Sm"; elementNumber = e; family = 9; break;
            case 63 :  elementName = "Europium"; elementSymbol = "Eu"; elementNumber = e; family = 9; break;
            case 64 :  elementName = "Gadolinium"; elementSymbol = "Gd"; elementNumber = e; family = 9; break;
            case 65 :  elementName = "Terbium"; elementSymbol = "Tb"; elementNumber = e; family = 9; break;
            case 66 :  elementName = "Dysprosium"; elementSymbol = "Dy"; elementNumber = e; family = 9; break;
            case 67 :  elementName = "Holmium"; elementSymbol = "Ho"; elementNumber = e; family = 9; break;
            case 68 :  elementName = "Erbium"; elementSymbol = "Er"; elementNumber = e; family = 9; break;
            case 69 :  elementName = "Thulium"; elementSymbol = "Tm"; elementNumber = e; family = 9; break;
	    case 70 :  elementName = "Ytterbium"; elementSymbol = "Yb"; elementNumber = e; family = 9; break;
            case 71 :  elementName = "Lutetium"; elementSymbol = "Lu"; elementNumber = e; family = 9; break;
            case 72 :  elementName = "Hafnium"; elementSymbol = "Hf"; elementNumber = e; family = 4; break;
            case 73 :  elementName = "Tantalum"; elementSymbol = "Ta"; elementNumber = e;  family = 4; break;
            case 74 :  elementName = "Tungsten"; elementSymbol = "W"; elementNumber = e;  family = 4; break;
            case 75 :  elementName = "Rhenium"; elementSymbol = "Re"; elementNumber = e;  family = 4; break;
            case 76 :  elementName = "Osmium"; elementSymbol = "Os"; elementNumber = e; family = 4; break;
            case 77 :  elementName = "Iridium"; elementSymbol = "Ir"; elementNumber = e;  family = 4; break;
            case 78 :  elementName = "Platinum"; elementSymbol = "Pt"; elementNumber = e; family = 4; break;
            case 79 :  elementName = "Gold"; elementSymbol = "Au"; elementNumber = e; family = 4; break;
	    case 80 :  elementName = "Mercury"; elementSymbol = "Hg"; elementNumber = e; family = 4; break;
            case 81 :  elementName = "Thallium"; elementSymbol = "Tl"; elementNumber = e; family = 5; break;
            case 82 :  elementName = "Lead"; elementSymbol = "Pb"; elementNumber = e; family = 5; break;
            case 83 :  elementName = "Bismuth"; elementSymbol = "Bi"; elementNumber = e; family = 5; break;
            case 84 :  elementName = "Polonium"; elementSymbol = "Po"; elementNumber = e; family = 6; break;
            case 85 :  elementName = "Astatine"; elementSymbol = "At"; elementNumber = e; family = 7; break;
            case 86 :  elementName = "Radon"; elementSymbol = "Rn"; elementNumber = e; family = 8; break;
            case 87 :  elementName = "Francium"; elementSymbol = "Fr"; elementNumber = e; family = 2; break;
            case 88 :  elementName = "Radium"; elementSymbol = "Ra"; elementNumber = e;  family = 3; break;
            case 89 :  elementName = "Actinium"; elementSymbol = "Ac"; elementNumber = e; family = 10; break;
	    case 90 :  elementName = "Thorium"; elementSymbol = "Th"; elementNumber = e;  family = 10; break;
            case 91 :  elementName = "Protactinium"; elementSymbol = "Pa"; elementNumber = e;  family = 10; break;
            case 92 :  elementName = "Uranium"; elementSymbol = "U"; elementNumber = e; family = 10; break;
            case 93 :  elementName = "Neptunium"; elementSymbol = "Np"; elementNumber = e; family = 10; break;
            case 94 :  elementName = "Plutonium"; elementSymbol = "Pu"; elementNumber = e; family = 10; break;
            case 95 :  elementName = "Americium"; elementSymbol = "Am"; elementNumber = e; family = 10; break;
            case 96 :  elementName = "Curium"; elementSymbol = "Cm"; elementNumber = e; family = 10; break;
            case 97 :  elementName = "Berkelium"; elementSymbol = "Bk"; elementNumber = e; family = 10; break;
            case 98:  elementName = "Californium"; elementSymbol = "Cf"; elementNumber = e;  family = 10; break;
            case 99 :  elementName = "Einsteinium"; elementSymbol = "Es"; elementNumber = e; family = 10; break;
	    case 100 :  elementName = "Fermium"; elementSymbol = "Fm"; elementNumber = e; family = 10; break;
	    case 101 :  elementName = "Mendelevium"; elementSymbol = "Md"; elementNumber = e; family = 10; break;
            case 102 :  elementName = "Nobelium"; elementSymbol = "No"; elementNumber = e; family = 10; break;
            case 103 :  elementName = "Lawrencium"; elementSymbol = "Lr"; elementNumber = e; family = 10; break;
            case 104 :  elementName = "Rutherfordium"; elementSymbol = "Rf"; elementNumber = e; family = 4; break;
            case 105 :  elementName = "Dubnium"; elementSymbol = "Db"; elementNumber = e; family = 4; break;
            case 106 :  elementName = "Seaborgium"; elementSymbol = "Sg"; elementNumber = e; family = 4; break;
            case 107 :  elementName = "Bohrium"; elementSymbol = "Bh"; elementNumber = e; family = 4; break;
            case 108 :  elementName = "Hassium"; elementSymbol = "Hs"; elementNumber = e; family = 4; break;
            case 109 :  elementName = "Meitnerium"; elementSymbol = "Mt"; elementNumber = e; family = 4; break;
	    case 110 :  elementName = "Darmstadtium"; elementSymbol = "Ds"; elementNumber = e;  family = 4; break;
            case 111 :  elementName = "Roentgenium"; elementSymbol = "Rg"; elementNumber = e; family = 4; break;
            case 112 :  elementName = "Copernicium"; elementSymbol = "Cn"; elementNumber = e; family = 4; break;
            case 113 :  elementName = "Ununtrium"; elementSymbol = "Uun"; elementNumber = e; family = 5; break;
            case 114 :  elementName = "Flerovium"; elementSymbol = "Fl"; elementNumber = e; family = 5; break;
            case 115 :  elementName = "Ununpentium"; elementSymbol = "Uup"; elementNumber = e; family = 5; break;
            case 116 :  elementName = "Livermorium"; elementSymbol = "Lv"; elementNumber = e; family = 5; break;
            case 117 :  elementName = "Ununseptium"; elementSymbol = "Uus"; elementNumber = e; family = 7; break;
            case 118 :  elementName = "Ununoctium"; elementSymbol = "Uuo"; elementNumber = e; family = 8; break;
            
            default : elementName = "not an element"; elementSymbol = ":("; elementNumber = e; break;
       }
       
       
        jb.elementName = elementName;  
        jb.elementSymbol = elementSymbol;
        jb.elementNumber = elementNumber; 
        jb.atomicMass =  atomicMass; 
        jb.type =  family;
        jb.addActionListener(this);
        jb.setText("<html><h1>"+elementSymbol+"<h1></html>");
       
       
       
       
       
}  // end get element 
    
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
     
 
 
 
 
                 //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
private int row(int r){
    int pixelNumber = ((r-1)*(int)(space.Space.height/15))+20;
    return pixelNumber;
}   

private int column(int c){ 
    int columnPixelNumber = 0;
    
    switch(c){  // these arent in cardinal order, i've been readjusting layouts
        //case 1: columnPixelNumber = (space.Space.width/8)*1; break;
            
                case 1: columnPixelNumber   = (int)(space.Space.width*.022); break;
                case 2: columnPixelNumber   = (int)(space.Space.width*.16); break;
                case 3: columnPixelNumber   = (int)(space.Space.width*.25); break;
                case 4: columnPixelNumber   = (int)(space.Space.width*.42); break;
                case 5: columnPixelNumber   = (int)(space.Space.width*.52); break;
                case 6: columnPixelNumber   = (int)(space.Space.width*.62); break;
                case 42: columnPixelNumber   = (int)(space.Space.width*.25); break;    
    }
    return columnPixelNumber;
} // end column
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
 
 
 
 
 // this is a trial, see if it works...
 
public void createArrayWithGaps(){
    int atomicNombre = 1;
    for(int i = 1; i < 157; i++){
     
       if(i==1){
      atomicNombre = 1;   
     } 
       if(i>1 && i < 18){
      atomicNombre = 0;   
     } 
      if(i==18){
      atomicNombre = 2;   
     }
       if(i>20 && i < 32){
      atomicNombre = 0;   
     }
     if(i==31){
      atomicNombre = 5;   
     }  
        if(38 < i && i < 49){
      atomicNombre = 0;   
     }
        if(i==49){
      atomicNombre = 13;   
     }  
     
     
     
      if(i==93){
      atomicNombre = 0;   
     }  
        if(i==94){
      atomicNombre = 72;   
     } 
      if(i==111){
      atomicNombre = 0;   
     }    
        if(i==112){
      atomicNombre = 104;   
     }   
        
        
        
    periodicTableChartNumbers.add(atomicNombre);
    atomicNombre++;
    
    
    
    
    }  // end for loop
    
    
    // insert zeros into the array
    
    
    
    
    
} // end create array with gaps
 

public void colorChart(){
    
    for(int r = 0; r < elements.size(); r++){

        colorNonMetal(r);
        colorSemiMetal(r);
        colorAlkaliMetal(r);
        colorAlkalineEarth(r);
        colorTransitionMetal(r);
        colorBasicMetal(r);
        colorHalogen(r);
        colorNobleGas(r);
        colorLanthanide(r);
        colorActinide(r);
  
    }
  
    
} // end color chart

public void colorElement(int r){
    
    

        colorNonMetal(r);
        colorSemiMetal(r);
        colorAlkaliMetal(r);
        colorAlkalineEarth(r);
        colorTransitionMetal(r);
        colorBasicMetal(r);
        colorHalogen(r);
        colorNobleGas(r);
        colorLanthanide(r);
        colorActinide(r);
  
    
} // end color element




  public void colorNonMetal(int i){
      if(elements.get(i).type == 1){
     elements.get(i).setBackground(Color.BLUE);
      }
 }
 
 public void colorAlkaliMetal(int i){
     if(elements.get(i).type == 2){
     elements.get(i).setBackground(Color.RED);
     }
 }
 
  public void colorAlkalineEarth(int i){
       if(elements.get(i).type == 3){
     elements.get(i).setBackground(Color.ORANGE);
       }
 
 }
  
   public void colorTransitionMetal(int i){
   if(elements.get(i).type == 4){
     elements.get(i).setBackground(Color.YELLOW);
   }
 } 
  
  public void colorBasicMetal(int i){
      if(elements.get(i).type == 5){
     elements.get(i).setBackground(Color.GREEN);
  }
 }
 

  public void colorSemiMetal(int i){
     if(elements.get(i).type == 6){
    
     elements.get(i).setBackground(Color.GRAY);
     }
 }
 

  public void colorHalogen(int i){
      if(elements.get(i).type == 7){
     elements.get(i).setBackground(Color.PINK);
      }
 }
 
  public void colorNobleGas(int i){
      if(elements.get(i).type == 8){
     elements.get(i).setBackground(Color.WHITE);
      }
 }
  
   public void colorLanthanide(int i){
       if(elements.get(i).type == 9){
   
     elements.get(i).setBackground(Color.MAGENTA);
       }
 }
 
  public void colorActinide(int i){
      if(elements.get(i).type == 10){
 
     elements.get(i).setBackground(Color.CYAN);
      }
 }

 
 public void addListeners(){ // not using this now
     
     for(int i = 0; i < elements.size(); i++){
         
         
         elements.get(i).addActionListener(this);

     }

     
 }  
 
  
     
  
  
    public void actionPerformed(ActionEvent e) {
        
        
        Object o = e.getSource();
        if(o == backButton){
            
            space.Space.screen.startPanel();
            
        }else if(o == showCardsButton){
            if(space.Space.showCards){
                space.Space.showCards = false;
                cardHolder.setVisible(false);
                showCardsButton.setText("Show Card");
            }else{
                space.Space.showCards = true;
                cardHolder.setVisible(true);
                showCardsButton.setText("Hide Card");
                
            }
            
        }else{
        
        
        	Element obj = (Element)e.getSource();
        
                
                for(int k = 0; k < elements.size(); k++){
                    
                
                
                            if (obj == elements.get(k)){
                                
                                    space.Space.currentSelectedElectronNumber = elements.get(k).elementNumber;
                                    space.Space.showCards = true;
                                   // a = new Atom();
                                   // a.repaint();
                                  //  a.setVisible(true);
                                   // add(a);
                                           // if(space.Space.showCards){
                                                cardHolder.setBackground(Color.white);
                                               space.Space.globalElementSymbol =  elements.get(k).elementSymbol;
                                                space.Space.globalElementName =elements.get(k).elementName;
                                                space.Space.globalElementNumber =elements.get(k).elementNumber;
                                                space.Space.globalAtomicMass =elements.get(k).atomicMass;
                                                cardHolder.setVisible(true);
                                           // }else{

                                              //  cardHolder.setVisible(false);
                                           // }  // end if(space.Space.showCards){
                                space.Space.screen.elementViewerPanel();  
  
                            }  // enf if obj == elements.get(k)
  
                }
  
        }
    
    
    } // end action performed
    
    
  public void setAtomVariables(){
      
      space.Space.globalParticleSize = 4;
                
                space.Space.globalParticleSizeMultiplier = 8;
                space.Space.globalAmountOfParticles = 6000;
                space.Space.globalSingularGravity = true;
                space.Space.particles = true;
                space.Space.globalEnemySpeed = 1;
                space.Space.gravityGetsStronger = false;
                space.Space.globalhelioSpeed = 10;
                space.Space.globalTimerSpeed = 1;
                space.Space.globalSpeedlimit = 42;// + heroSize;// douglas adams is max
                space.Space.globalMinSpeed = 12;
      
      
      
  }  
    public void showCard(){
        
        
        
        
    }
    
    
} // end
