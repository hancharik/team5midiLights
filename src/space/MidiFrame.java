/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;





import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Sequencer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mark
 */
public class MidiFrame extends JFrame{
    
    
     ArrayList <JButton> notecards = new ArrayList();
        
    JPanel p = new JPanel();
    JPanel notePanel = new JPanel();
    JLabel iLabel;
    JLabel jLabel;
    JLabel kLabel;
    JButton showInstruments;
    JButton playRandom;
    JButton playSong;
    JButton stopSong;
    JButton chooseSong;
    String songName = "MachineGun(Live)";
     Sequencer sequencer = null;
            
                 
    
       public MidiFrame (){
            
           
           
           
            
		super ("MIDI sound dojo");
                addComponents();
                
                //sequencer = null;
                
                 notePanel.setBounds(100, 300, 400, 400);
                notePanel.setBackground(Color.red);
               // p.add(notePanel);
                 notecards = new ArrayList();
                
                 p.setBackground(Color.black);
		
           // p = new JPanel();
            this.getContentPane().add(p,"Center");
            setSize (1200, 1000);
            setVisible(true);
            //town.me.requestFocusInWindow();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setSize (townWidth, townHeight);
		//setVisible(true);
                //this.requestFocus();  // had to take this out for the main button to get focus, for the KeyListener to work
                
	}  // end constructor
       
       
       
       
       
       
       
       
       
       
       
       
  public void addComponents(){
           
        iLabel = new JLabel("<html><h2><font color='white'>instrument = </font><font color='yellow'>"  + "</font><h2></html>");
        jLabel = new JLabel("<html><h2><font color='white'>instrument = </font><font color='yellow'>"  + "</font><h2></html>");
        kLabel = new JLabel("<html><h2><font color='white'>instrument = </font><font color='yellow'>"  + "</font><h2></html>");
        iLabel.setBounds(20, 60, 300, 60);
        jLabel.setBounds(20, 140, 300, 60);
        kLabel.setBounds(20, 240, 300, 68);
        showInstruments = new JButton("show instruments");
        showInstruments.setBounds(20, 20, 160, 40);
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        showInstruments.addActionListener(new ActionListener() {
 //http://www.javaprogrammingforums.com/java-swing-tutorials/278-how-add-actionlistener-jbutton-swing.html
            public void actionPerformed(ActionEvent e)
            {
              showAvailableInstruments();
                //playRandomStuff();
               // playMidiSong();
            }

            
        });
    /////////////////////////////////////////////////////////////////////////////////////////    
        
                 playRandom = new JButton("play random");
         playRandom.setBounds(200, 20, 160, 40);
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
         playRandom.addActionListener(new ActionListener() {
 //http://www.javaprogrammingforums.com/java-swing-tutorials/278-how-add-actionlistener-jbutton-swing.html
            public void actionPerformed(ActionEvent e)
            {
             // showAvailableInstruments();
                playRandomStuff();
                //playMidiSong();
                //playThroughTheNotes();
            }

            
        });
    ///////////////////////////////////////////////////////////////////////////////////////// 
        
                playSong = new JButton("play song");
        playSong.setBounds(400, 20, 160, 40);
        playSong.setVisible(false);
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        playSong.addActionListener(new ActionListener() {
 //http://www.javaprogrammingforums.com/java-swing-tutorials/278-how-add-actionlistener-jbutton-swing.html
            public void actionPerformed(ActionEvent e)
            {
                try {
                    // showAvailableInstruments();
                    //playRandomStuff();
                    playSong.setVisible(false);
                    stopSong.setVisible(true);
                    playMidiSong();
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(MidiFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MidiFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(MidiFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
        });
    ///////////////////////////////////////////////////////////////////////////////////////// 
        
        
                
                stopSong = new JButton("stop song");
        stopSong.setBounds(600, 80, 160, 40);
        stopSong.setVisible(false);
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        stopSong.addActionListener(new ActionListener() {
 //http://www.javaprogrammingforums.com/java-swing-tutorials/278-how-add-actionlistener-jbutton-swing.html
            public void actionPerformed(ActionEvent e)
            {
               
                  
                    stopSong.setVisible(false);
                    chooseSong.setVisible(true);
                     sequencer.close();
                   // stopSong.getParent().this.dispose();      
              
            }

            
        });
    ///////////////////////////////////////////////////////////////////////////////////////// 
   
        
        
                   ///////////////////////////////////////////////////////////////////////////////////////// 
        
                chooseSong = new JButton("choose song");
        chooseSong.setBounds(600, 20, 160, 40);
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        chooseSong.addActionListener(new ActionListener() {
 //http://www.javaprogrammingforums.com/java-swing-tutorials/278-how-add-actionlistener-jbutton-swing.html
            public void actionPerformed(ActionEvent e)
            {
             // showAvailableInstruments();
                //playRandomStuff();
                showChooser();
            }

            
        });
    ///////////////////////////////////////////////////////////////////////////////////////// 
        
         notecards = new ArrayList();
         p = new JPanel();
        p.setSize (1200, 1000);
         p.setLayout(null);
         p.setBackground(Color.blue);
        JButton b = new JButton();
        notecards.add(b);
        b.setBounds(60, 60, 20, 20);
       b.setBackground(Color.green);
       p.add(b);
        p.add(iLabel);
        p.add(jLabel);
        p.add(kLabel);
        p.add(showInstruments);
        p.add(playRandom);
        p.add(playSong);
        p.add(stopSong);
        p.add(chooseSong);
      
      
  }     
       
       
       
public void setColor(JButton buttonToColor, int level){
    
    if(level < 20){
            buttonToColor.setBackground(Color.red);
                 
         }
        if(level >= 20 && level < 30){
            buttonToColor.setBackground(Color.magenta);
                 
         }
         if(level >= 30 && level< 40){
            buttonToColor.setBackground(Color.blue);
                 
         }
          if(level >= 40 && level < 50){
            buttonToColor.setBackground(Color.green);
                 
         }
           if(level >= 50 && level < 60){
            buttonToColor.setBackground(Color.yellow);
                 
         }
           
           if(level >= 60 && level <= 70){
            buttonToColor.setBackground(Color.orange);
                 
         }
     if(level > 70){
            buttonToColor.setBackground(Color.white);
                 
         }
    
}       
       
 public void playRandomStuff(){
     
     //http://stackoverflow.com/questions/30718831/midi-midimessage-program-change-with-instrument-from-different-bank
      
   
           int instrument;
         int bank;       
         int note;
         int volume;
         int pause;
         int yAxis;
             try {
         Synthesizer synthesizer = MidiSystem.getSynthesizer();
         synthesizer.open();
 
         MidiChannel[] channels = synthesizer.getChannels();
 
         for(int i = 0; i < 4000; i++){
          note = (int) (Math.random() * 127) + 1; 
          pause = 1;//(int) (Math.random() * 1900) +  100; 
          volume = (int) (Math.random() * 60) +  20;
        instrument = 384;//(int) (Math.random() * 124) + 1;
        bank = 0;//(int) (Math.random() * 10) + 1;    
         
         channels[0].programChange(bank ,instrument );
        channels[0].noteOn( note, volume);
         JButton b = new JButton();
         notecards.add(b);
          notecards.get(i).setBounds( volume*13  + 40, 800-(note*9), 20, 20);
          setColor(this.notecards.get(i), note);
          
           //notePanel.add(b);
          //notePanel.repaint();
            p.add(b);
          p.repaint();
           //f.pack();
         Thread.sleep(pause);
         channels[0].noteOff(note);
         
         }
         synthesizer.close();
     } catch (Exception e)
     {
         e.printStackTrace();
     }
        
     
     
     
     
     
     
     
     
            
    }  // end play random stuff
  
     
  public void playThroughTheNotes(){
     
        int instrument;
        int bank;
        int note;
        int note1;
        int volume;
        int pause;
        int yAxis;
            try {
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();

        MidiChannel[] channels = synthesizer.getChannels();

        
        /*
        //http://stackoverflow.com/questions/30718831/midi-midimessage-program-change-with-instrument-from-different-bank
      
        MidiChannel channel = synthesizer.getChannels()[0];
if (channel != null) {
    channel.programChange(bank, instrument);
    channel.noteOn(70, 100);
}
        
        here's how we use the values in the program. 
        channels[0].programChange(BANK ,INSTRUMENT );
        channels[0].noteOn( NOTE, VOLUME);
        Thread.sleep(PAUSE); <-- the time between notes. right now note 1 stops, note 2 starts
        */
        
        // this is a test then, that runs through the first bank
        
        for(int j = 0; j < 10; j++){
        for(int i = 0; i < 10; i=i+10){
        for(int k = 0; k < 100; k++){    
         
         //note1 = (int) (Math.random() * 110) + 1; 
       note =  (int) (Math.random() * 78 ) + 12; 
         
         pause = 1;//(int) (Math.random() * 400) + 1; 
         volume = (int) (Math.random() * 50) + 30;
         instrument = 384;//(int) (Math.random() * 124) + 1;
       // bank = (int) (Math.random() * 10) + 1;   
         
         
        
        
        
        this.iLabel.setText("<html><h2><font color='white'>instrument = </font><font color='yellow'>" + i + "</font><h2></html>");
      // http://www.java2s.com/Tutorial/Java/0240__Swing/SetFontandforegroundcolorforaJLabel.htm
         this.iLabel.setFont(new Font("Courier New", Font.BOLD, 12));
         this.jLabel.setText("<html><h2><font color='white'>pause = </font><font color='blue'>"  + pause + "</font><h2></html>");
         this.jLabel.setFont(new Font("Courier New", Font.BOLD, 22));
        this.kLabel.setText("<html><h2><font color='white'>note = </font><font color='green'>"  +  k + "</font><h2></html>");
        this.kLabel.setFont(new Font("Courier New", Font.BOLD, 22));
        
        this.iLabel.setVisible(true);
        this.jLabel.setVisible(true);
        this.kLabel.setVisible(true);
        
        
        
        
        //if(k%2==0){
       // channels[0].programChange(0 ,i );
      //  channels[0].noteOn( note, volume);
      //  }
        JButton b = new JButton();
        b.setBorderPainted(false);
        b.setOpaque(true);
        this.notecards.add(b);
        this.notecards.get(i).setBounds( volume*7, 600-(note*4), 20, 20);
        this.setColor(this.notecards.get(i), note);
        this.p.add(b);
         //second note
         //channels[1].programChange(bank ,instrument);
        //channels[1].noteOn( note - 11, volume);
     
          JButton bz = new JButton();
        bz.setBorderPainted(false);
        bz.setOpaque(true);
        this.notecards.add(bz);
         this.notecards.get(i+1).setBounds( volume*10, 900-(note*8), 20, 20);
         this.setColor(this.notecards.get(i+1), note);
         this.p.add(bz);
          this.p.repaint();
         
          //this.pack();
          this.repaint();
        this.p.repaint();
        //channels[0].programChange(0 ,i );
       // channels[0].noteOn( note, volume);
        Thread.sleep(pause);
       // channels[0].noteOff(note);
        //channels[1].noteOff(note1);
        }
        }
            }
        
        
       // */
        /*
           for(int i = 0; i < 100; i++){
            
         note = (int) (Math.random() * 110) + 1; 
         pause = (int) (Math.random() * 300) + 100; 
         volume = (int) (Math.random() * 110) + 1;
         instrument = (int) (Math.random() * 25) + 1;
        bank = (int) (Math.random() * 10) + 1;   
         
         
         // bank zero, instrument 25 is the 808
        channels[0].programChange(bank , instrument );
        channels[0].noteOn(note, volume);
       
        JButton b = new JButton();
        b.setBorderPainted(false);
        b.setOpaque(true);
        this.notecards.add(b);
         this.notecards.get(i).setBounds( volume*11, 900-(note*9), 20, 20);
         this.setColor(this.notecards.get(i), note);
         
          this.p.add(b);
          this.p.repaint();
          //this.pack();
        
        Thread.sleep(pause);
        
        channels[0].noteOff(note);
        
        }
         */  
           
           
        synthesizer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    }
  
 
 
 
 
 
 
 
     
       public void showAvailableInstruments() {
           try{
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        Instrument[] orchestra = synthesizer.getAvailableInstruments();

        final StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        sb.append("The orchestra has ");
        sb.append(orchestra.length);
        sb.append(" instruments.");
        sb.append(eol);
        for (Instrument instrument : orchestra) {
            sb.append(instrument.toString());
            sb.append(eol);
        }
        synthesizer.close();

        Runnable r = new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null,
                        new JScrollPane(new JTextArea(sb.toString(), 20, 30)));
            }
        };
        SwingUtilities.invokeLater(r);
        } catch (Exception e)
    {
        e.printStackTrace();
    }
    } // end show available instruments 
     
       
       
       
       
       
       
       
       
       
  public void playMidiSong() throws MidiUnavailableException, FileNotFoundException, IOException, InvalidMidiDataException{
      
      
      InputStream is = null; 
      
      // sequencer = MidiSystem.getSequencer();
       //  if( sequencer.isRunning()){
         
      //     sequencer.close();
      //  }
          
       
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            is = new BufferedInputStream(new FileInputStream(new File("midi/" + songName)));// + ".mid")));
            sequencer.setSequence(is);
            sequencer.start();
            is.close();
           // this.dispose();
      
   } // end play midi song
  
  
  
 
       
   
  
  
      
   public void showChooser(){  // this is from the example marc linked to in the google drive
      
                      JFileChooser  chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("./midi/"));
       FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "MIDI files", "mid");
    chooser.setFileFilter(filter);
    chooser.setDialogTitle("pick a song");
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      chooseSong.setVisible(false);
      playSong.setVisible(true);
      songName = chooser.getSelectedFile().getName();
      }
    else {
      System.out.println("No Selection ");
      }
  }
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
} // end
