package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//required for border
import javax.swing.BorderFactory;
import javax.swing.border.Border;
//required for file IO
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
//required for exception
import java.io.IOException;

class StatusPanel extends JPanel{
   //list all UI components for the panel
   JLabel outputlabel;
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

   //global variable  
   String output="";
   String filePath="Employee Leave Application Form.txt"; //in the same directory
   
   public StatusPanel(){              
      //adjust size and set layout
      setPreferredSize (new Dimension (560, 530));
      setLayout (null);
            
      outputlabel = new JLabel("Click View Data in Menu to Load Employee Leave Application Form");
      outputlabel.setBounds (20, 20, 500, 25);
      outputlabel.setBorder(border);
      outputlabel.setVerticalAlignment(JLabel.TOP);
      
      //add output label to scrollpane
      jsp = new JScrollPane(outputlabel);
      jsp.setBounds (20, 20, 500, 300);
      add(jsp);   
}
}

class MenuActionListener implements ActionListener {
   StatusPanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener(StatusPanel p){
      fp = p;
   }
    public void actionPerformed(ActionEvent e) {
       BufferedReader reader;
 	   try {
 			reader = new BufferedReader(new FileReader(fp.filePath));
 			String line = reader.readLine();
          String output="<html>";
 			while (line != null) {
 				output += line + "<br>";
 				// read next line
 				line = reader.readLine();
 			}
          output += "<br>";
          fp.outputlabel.setText(output);
 			reader.close();
 		} catch (IOException io) {
 			fp.outputlabel.setText(io.toString());
 		}
 
   }
 }

//run the application using this main
public class ApplicationStatus {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Employee Leave Application Status");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      f.getContentPane().add (new StatusPanel());
      StatusPanel fp = new StatusPanel();
      
      JMenuBar mb = new JMenuBar(); 
      // create a menu 
      JMenu x = new JMenu("Menu"); 
      
      // create menuitems 
      JMenuItem m1 = new JMenuItem("View Data"); 
      // attach listener and send FormPanel class
      m1.addActionListener(new MenuActionListener(fp));
      
      JMenuItem m2 = new JMenuItem("Exit");  
      m2.addActionListener((event) -> System.exit(0));
      // add menu items to menu 
      x.add(m1); 
      x.add(m2);
     
      // add menu to menu bar 
      mb.add(x); 
      // add menubar to frame 
      f.setJMenuBar(mb);  
               
      //add panels to frame      
      f.add(fp);
      f.pack();
      f.setVisible(true);
   }  
}