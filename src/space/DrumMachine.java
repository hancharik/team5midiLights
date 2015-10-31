
package space;







/**
 *
 * From Head First Java, 2nd Ed. ISBN: 0596009208, page 420
 * 
 * 
 *      http://www.midi.org/techspecs/midimessages.php
 */


import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;






public class DrumMachine extends JPanel{

 
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;// = fullscreengame.FullScreenGame.sequencer;
    Sequence sequence;
    Track track;
    
    JButton start;
    JButton stop;
    JButton upTempo;
    JButton downTempo;
    JButton saveButton;
    JButton loadButton;
    
     
    
    String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
        "Crash Cymbal","Hand Clap","Hi Tom","Hi Bongo","Maracas","Whistle",
        "Low Conga","Cowbell","Vibraslap","Lo-mid Tom","Hi Agogo","Open Hi Conga",};
    
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
    
    public DrumMachine(){
       
        buildGUI();
    }
    
    
    
    public void buildGUI(){
        
        
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setBackground(Color.black);
        
        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        
        start = new JButton("<html><h2><font color='white'>start</font><h2></html>");
        start.setBackground(Color.black);
        start.setBorderPainted(false);
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        
        stop = new JButton("<html><h2><font color='white'>stop</font><h2></html>");
        stop.setBackground(Color.black);
        stop.setBorderPainted(false);
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);
        
        upTempo = new JButton("<html><h2><font color='white'>speed up</font><h2></html>");
        upTempo.addActionListener(new MyUpTempoListener());
        upTempo.setBackground(Color.black);
        upTempo.setBorderPainted(false);
        buttonBox.add(upTempo);
        
        downTempo = new JButton("<html><h2><font color='white'>slow down</font><h2></html>");
        downTempo.addActionListener(new MyDownTempoListener());
        downTempo.setBackground(Color.black);
        downTempo.setBorderPainted(false);
        buttonBox.add(downTempo);
        
        saveButton = new JButton("<html><h2><font color='white'>save</font><h2></html>");
        saveButton.addActionListener(new MySendListener());
        saveButton.setBackground(Color.black);
        saveButton.setBorderPainted(false);
        buttonBox.add(saveButton);
        
        loadButton = new JButton("<html><h2><font color='white'>load</font><h2></html>");
        loadButton.addActionListener(new MyReadInListener());
        loadButton.setBackground(Color.black);
        loadButton.setBorderPainted(false);
        buttonBox.add(loadButton);
        
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(int i = 0; i < 16; i++){
           nameBox.add(new JLabel("<html><h3><font color='white'>" + instrumentNames[i] + "</font><h3></html>")); 
        }
        
        this.add(BorderLayout.EAST, buttonBox);
        this.add(BorderLayout.WEST, nameBox);
        
       
        
        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        mainPanel.setBackground(Color.black);
        this.add(BorderLayout.CENTER, mainPanel);
        
        for(int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            c.setBackground(colorBeats(i));
            checkboxList.add(c);
            mainPanel.add(c);
        
        }  
        setUpMidi();
        
        
       
        
    }// end create GUI
    
 
    public Color colorBeats(int count){
        Color newColor = Color.white;
       switch(count%4){
           case 0 :   newColor = Color.white; break;
           case 1 :   newColor = Color.lightGray; break;
           case 2 :   newColor = Color.gray; break;
            case 3 :   newColor = Color.darkGray; break;
           
           
           
           
           
       } 
        
        
       return newColor; 
        
    }
    
    
    
    
  public void setUpMidi(){
      try{
         sequencer = MidiSystem.getSequencer();
         sequencer.open();
         sequence = new Sequence(Sequence.PPQ, 4);
         track = sequence.createTrack();
         
         sequencer.setTempoInBPM(120);
      } catch(Exception e){
          e.printStackTrace();
      }
  }  // end set up midi
    
    
    
   public void buildTrackAndStart(){
       
       int[] trackList = null;
       
       sequence.deleteTrack(track);
       track = sequence.createTrack();
       
       for(int i = 0; i < 16; i++){
           trackList = new int[16];
           
           int key = instruments[i];
           
           for(int j = 0; j < 16; j++){
               JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));// <-- very nice!
               if(jc.isSelected()){
                   trackList[j] = key;
               }else{
                   trackList[j] = 0; 
               }
           } // end for j
           makeTracks(trackList);
           track.add(makeEvent(176,1,127,0,16));
       } // end for i
       
       
       track.add(makeEvent(192,9,1,0,15));
       try{
          sequencer.setSequence(sequence);
          sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
          sequencer.start();
          sequencer.setTempoInBPM(120);
       }catch(Exception e){
           e.printStackTrace();
       }
 
       
       
   } // end build track and start
     
    
  public class MyStartListener implements ActionListener{
      public void actionPerformed(ActionEvent a){
          buildTrackAndStart();
      }
      
  }
    
   public class MyStopListener implements ActionListener{
      public void actionPerformed(ActionEvent a){
          sequencer.stop();
      }
      
  }  
    
    
   public class MyUpTempoListener implements ActionListener{
      public void actionPerformed(ActionEvent a){
          float tempoFactor = sequencer.getTempoFactor();
          sequencer.setTempoFactor((float)(tempoFactor * 1.03));
          upTempo.setText("tempo: " + sequencer.getTempoFactor());
          
      }
      
  }  
    
   public class MyDownTempoListener implements ActionListener{
      public void actionPerformed(ActionEvent a){
          float tempoFactor = sequencer.getTempoFactor();
          sequencer.setTempoFactor((float)(tempoFactor * .97));
          upTempo.setText("tempo: " + sequencer.getTempoFactor());
      }
      
  }  
    
    
  public void makeTracks(int[] list){
      
      for(int i = 0; i < 16; i++){
          int key = list[i];
          
          if(key != 0){
             track.add(makeEvent(144,9,key,100,i));
             track.add(makeEvent(128,9,key,100,i+1));
          }
      }
      
  
  }  // end make tracks
    
    
  public MidiEvent makeEvent(int command, int channel, int one, int two, int tick){
     MidiEvent event = null; 
      
      try{
        ShortMessage a = new ShortMessage();
        a.setMessage(command, channel, one, two);
        event = new MidiEvent(a, tick);
      } catch(Exception e){
          e.printStackTrace();
      }
      
      
      return event;
  }  
    
    
 public class MySendListener implements ActionListener{
     public void actionPerformed(ActionEvent a){
         boolean[] checkboxState = new boolean[256];
         
         for(int i = 0; i < 256; i++){
             JCheckBox check = (JCheckBox) checkboxList.get(i);
             if(check.isSelected()){
                 checkboxState[i] = true;
             }
         }
         try{
            FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkboxState);
         }catch(Exception ex){
            ex.printStackTrace();
         }
         
     }
 } // end my send listener 
    
    
 public class MyReadInListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
        boolean[] checkboxState = null;
        try{
           FileInputStream fileIn = new FileInputStream(("Checkbox.ser")); 
           ObjectInputStream is = new ObjectInputStream(fileIn);
           checkboxState = (boolean[]) is.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
       for(int i=0; i < 256; i++){
          JCheckBox check = (JCheckBox) checkboxList.get(i);
          if (checkboxState[i]){
              check.setSelected(true);
          }else{
              check.setSelected(false);
          }
       }
       
       sequencer.stop();
       buildTrackAndStart();
    } 
     
     
     
 }   // end my read in listener
    
    
    
    
}// end
